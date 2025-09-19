package com.greedy.chinema.service;

import com.greedy.chinema.Movie;
import com.greedy.chinema.persistence.MovieRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieService {
        private MovieRepository movieRepository;
        public MovieService() {
        }
        public Map<String,Long> movieNameInfo(){
            return movieRepository.getMovie().stream().
                    collect(
                            Collectors.groupingBy(
                                    Movie::getTitle, Collectors.counting()
                            ));
        }
        public void movieDateTimeInfo(String movieName){
             movieRepository.getMovie().stream().filter(movie->movie.getTitle().equals(movieName)).forEach(Movie::getReleaseDate);
//stream을 map으로 반환
        }
}
