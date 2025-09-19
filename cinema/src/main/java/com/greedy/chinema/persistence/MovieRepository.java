package com.greedy.chinema.persistence;

import com.greedy.chinema.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private List<Movie> movies;
    public MovieRepository(){
       // movies=new ArrayList<>();
    }
    public void insertMovie(Movie movie) {
        movies.add(movie);
    }
    public List<Movie> getMovie() {
        return movies;
    }

}
