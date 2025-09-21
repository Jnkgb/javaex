package com.greedy.chinema.ui;

import com.greedy.chinema.Movie;
import com.greedy.chinema.persistence.*;
import com.greedy.chinema.service.MovieService;

import java.time.LocalDateTime;
import java.util.*;

public class Application {
    private final MovieService movieService;
    private final MovieRepository movieRepository;
    private final Scanner scanner;

    public Application() {
        scanner = new Scanner(System.in);
        movieRepository=new MovieRepository();
        movieService = new MovieService(movieRepository);
    }


    public  void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            /**/
            System.out.println("========영화 예매 시스템========");
            System.out.println("1.영화 조회");
            System.out.println("2.영화 등록");
            System.out.println("3.종료");
            System.out.print("입력 해주세요:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("예매 가능한 영화 목록입니다.");
                    System.out.println(movieService.movieNameInfo());
                    System.out.print("예매할 영화 제목을 입력하세요: ");
                    String movieName = scanner.nextLine();
                    Movie selectedMovie = movieService.getMovieByTitle(movieName);
                    if (selectedMovie == null) {
                        System.out.println("해당 영화의 상영 정보가 없습니다.");
                        break;
                    }

                    System.out.println("'" + movieName + "'의 상영 시간입니다. 관람할 시간대의 번호를 선택하세요.");


                    Map<String, LocalDateTime> movieTimes = selectedMovie.getReleaseDate();
                    List<Map.Entry<String, LocalDateTime>> options = new ArrayList<>(movieTimes.entrySet());

                    for (int i = 0; i < options.size(); i++) {
                        Map.Entry<String, LocalDateTime> entry = options.get(i);
                        System.out.println((i + 1) + ". " + entry.getKey() + " " + entry.getValue());
                    }

                    System.out.print("선택: ");
                    int selection = Integer.parseInt(scanner.nextLine());
                    String chosenType = options.get(selection - 1).getKey();

                    try {

                        selectedMovie.printSeatMap(chosenType);

                        System.out.print("예매할 좌석을 입력하세요 (예: A5, C12): ");
                        String seatInput = scanner.nextLine().toUpperCase();
                        char rowChar = seatInput.charAt(0);
                        int row = rowChar - 'A';
                        int col = Integer.parseInt(seatInput.substring(1)) - 1;


                        boolean isBooked = movieService.bookSeatAndUpdate(selectedMovie, chosenType, row, col);

                        if (isBooked) {
                            System.out.println("좌석 " + seatInput + " 예매가 완료되었습니다. (저장 완료)");
                        } else {
                            System.out.println("이미 예매된 좌석이거나 잘못된 좌석입니다.");
                        }

                    } catch (Exception e) {
                        System.out.println("오류가 발생했습니다. 다시 시도해주세요: " + e.getMessage());
                    }
                }
                case 2 -> createMovie();
                case 3 -> {
                    System.out.println("시스템을 종료합니다.");
                    return;
                }
            }
        }

    }
    private void createMovie() {
        System.out.println("영화제목 감독이름 날짜와 영화관 종류를 입력해주세요");
        System.out.print("영화 제목 : ");
        String title = scanner.nextLine();
        System.out.print("감독 이름 : ");
        String director = scanner.nextLine();
        Map<String, LocalDateTime> newMovieTimes = new HashMap<>();
        while (true) {
            System.out.print("상영 정보 (그만두려면 n 입력, 형식: normal,2025-09-22T19:00) : ");
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("n")) break;
            try {
                String[] parts = str.split(",", 2);
                newMovieTimes.put(parts[0].trim(), LocalDateTime.parse(parts[1].trim()));
            } catch (Exception e) {
                System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
            }
        }

        Movie newMovie = new Movie(title, director, newMovieTimes);


        movieService.registerMovie(newMovie);

        System.out.println("'" + title + "' 영화가 성공적으로 등록 및 저장되었습니다.");
    }
    public static void main(String[] args){
        Application application=new Application();
        application.run();
    }
}
