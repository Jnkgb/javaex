package com.greedy.chinema.persistence;

import com.greedy.chinema.Movie;

import java.util.List;
public class MovieRepository {
    private final MovieStorage storage;
    private final List<Movie> movies;

    public MovieRepository() {
        storage = new FileMovieStorage();
        movies = storage.loadMovies();
    }

    public MovieRepository(MovieStorage storage) {
        this.storage = storage;
        movies = storage.loadMovies();
    }

    public List<Movie> findAll() {
        return movies;
    }

    public Movie findByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        storage.saveMovies(movies);
    }

    public void saveChanges() {
        storage.saveMovies(movies);
    }
}