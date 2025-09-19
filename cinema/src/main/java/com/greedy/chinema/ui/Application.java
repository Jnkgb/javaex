package com.greedy.chinema.ui;

import com.greedy.chinema.User;
import com.greedy.chinema.persistence.MovieRepository;
import com.greedy.chinema.service.MovieService;

import java.time.LocalDateTime;
import java.util.*;

public class Application {
    private final MovieService movieService;
    private final Scanner scanner;
    public Application() {
        scanner = new Scanner(System.in);
        movieService = new MovieService();
    }


    public  void run() {
        Scanner sc= new Scanner(System.in);

        while  (true){
            System.out.println("========영화 예매 시스템========");
            System.out.println("1.회원가입");
            System.out.println("2.로그인");
            System.out.println("3.영화조회");
            System.out.println("입력 해주세요:");

            sc.nextInt();
            switch (sc.nextInt()) {
                case 1 -> createUser();
                case 2 -> System.out.println("");
                case 3 -> {
                    System.out.print("예매할 영화를 선택 해주세요");
                    System.out.println(movieService.movieNameInfo());
                    System.out.print("예매할 영화 : ");
                    String movieName=sc.nextLine();
                    movieService.movieDateTimeInfo(movieName);
                }
                case 4-> System.out.println("");
            }
        }

    }
    private void createUser() {
        System.out.println("아이디 성함 비밀번호, 비밀번호 확인을 입력해주세요");
        System.out.println("아이디 : ");
        String id=scanner.nextLine();
        System.out.println("성함 : ");
        String name=scanner.nextLine();
        System.out.println("비밀번호 : ");
        String password=scanner.nextLine();

        User user=new User(id,name,password);

    }
    private void createMovie(){
        System.out.println("영화제목 감독이름 날짜와 영확관 종류를 입력해주세요");
        System.out.print("영화 제목 : ");
        String title=scanner.nextLine();
        System.out.print("감독 이름 : ");
        String director=scanner.nextLine();
        Map<String ,LocalDateTime> movieDateType=new HashMap<>();
        while  (true) {
            System.out.print("상영일 (그만 두고 싶으면 n을 입력 해주세요) : ");
            String str = scanner.nextLine();
            if (str.equals("n") || str.equals("N")) break;
            System.out.print("영화관 종류를 입력 해주세요 : ");
            String type=scanner.nextLine();
            movieDateType.put(type,LocalDateTime.parse(str));
        }
        com.greedy.chinema.Movie addMovie=new com.greedy.chinema.Movie(title,director,movieDateType);
        MovieRepository movieRepository=new MovieRepository();
        movieRepository.insertMovie(addMovie);
    }
    public static void main(String[] args){
        Application application=new Application();
        application.run();
    }
}
