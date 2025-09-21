package com.greedy.chinema.persistence;

import com.greedy.chinema.Movie;

import java.util.List;

public interface MovieStorage {
    List<Movie> loadMovies();

    void saveMovies(List<Movie> movies);
}
