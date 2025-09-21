package com.greedy.chinema.service;

import com.greedy.chinema.Movie;
import com.greedy.chinema.persistence.MovieRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }


    public void registerMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public boolean bookSeatAndUpdate(Movie movie, String type, int row, int col) {
        boolean isSuccess = movie.bookSeat(type, row, col);


        if (isSuccess) {
            movieRepository.saveChanges();
        }
        return isSuccess;
    }


    public Map<String, Long> movieNameInfo() {
        return movieRepository.findAll().stream()
                .collect(Collectors.groupingBy(Movie::getTitle, Collectors.counting()));
    }
}