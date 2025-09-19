package com.greedy.chinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Movie {
    private String title;
    private String director;
    private Map<String,LocalDateTime> movieDateType;
    private int[][] seat;

    public Movie(String director, String title,Map<String,LocalDateTime> movieDateType) {
        this.title = title;
        this.director = director;
        this.movieDateType = movieDateType;
    }

    public Map<String,LocalDateTime> getReleaseDate() {
        return movieDateType;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }
}
