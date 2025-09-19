package com.greedy.chinema.service;

import com.greedy.chinema.Movie;
import com.greedy.chinema.persistence.MovieRepository;

import java.util.List;

public class MovieService {
        private MovieRepository movieRepository;
        public MovieService() {
        }
        public List<String> movieNameInfo(){
            return movieRepository.getMovie().stream().map(Movie::getTitle).toList();
        }
}
