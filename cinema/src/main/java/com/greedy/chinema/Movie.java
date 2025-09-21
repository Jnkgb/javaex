package com.greedy.chinema;

import java.time.LocalDateTime;
import java.util.Map;

import com.greedy.chinema.persistence.MovieType;
import com.greedy.chinema.persistence.MovieTypeFactory;
import java.util.HashMap;

public class Movie {
    private String title;
    private String director;
    private Map<String, LocalDateTime> releaseDate;

    private Map<String, int[][]> seatMaps;
    private Map<String, MovieType> typeHandlers;
    public Movie(String title, String director, Map<String, LocalDateTime> releaseDate) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;

        this.seatMaps = new HashMap<>();
        this.typeHandlers = new HashMap<>();

        for (String type : releaseDate.keySet()) {
            try {
                MovieType handler = MovieTypeFactory.create(type);
                int[][] seats = handler.getSeat(type);

                this.typeHandlers.put(type, handler);
                this.seatMaps.put(type, seats);
            } catch (Exception e) {
                System.out.println(type + " 타입의 객체 생성에 실패했습니다.");
            }
        }
    }
    public Movie(String title, String director, Map<String, LocalDateTime> releaseDate, Map<String, String> seatData) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;

        this.seatMaps = new HashMap<>();
        this.typeHandlers = new HashMap<>();

        for (String type : releaseDate.keySet()) {
            try {
                MovieType handler = MovieTypeFactory.create(type);
                int[][] defaultSeats = handler.getSeat(type);
                int rows = defaultSeats.length;
                int cols = defaultSeats[0].length;
                int[][] seats = new int[rows][cols];


                if (seatData != null && seatData.containsKey(type)) {
                    String data = seatData.get(type);
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            int index = i * cols + j;
                            if (index < data.length()) {
                                // char '1' -> int 1
                                seats[i][j] = Character.getNumericValue(data.charAt(index));
                            }
                        }
                    }
                }

                this.typeHandlers.put(type, handler);
                this.seatMaps.put(type, seats);
            } catch (Exception e) {
                System.out.println(type + " 타입의 좌석 객체 생성에 실패했습니다.");
            }
        }
    }


    public void printSeatMap(String type) {
        MovieType handler = typeHandlers.get(type);
        int[][] seats = seatMaps.get(type);
        if (handler != null && seats != null) {
            handler.printSeat(seats);
        }
    }

    public boolean bookSeat(String type, int row, int col) {
        MovieType handler = typeHandlers.get(type);
        int[][] seats = seatMaps.get(type);
        if (handler != null && seats != null) {
            return handler.bookSeat(seats, row, col);
        }
        return false;
    }


    public String getTitle() { return title; }
    public Map<String, LocalDateTime> getReleaseDate() { return releaseDate; }

    public String getDirector() {
        return director;
    }

    public Map<String, int[][]> getSeatMaps() {
        return seatMaps;
    }
}
