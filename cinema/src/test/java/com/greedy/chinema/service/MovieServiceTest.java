package com.greedy.chinema.service;

import com.greedy.chinema.Movie;
import com.greedy.chinema.persistence.FileMovieStorage;
import com.greedy.chinema.persistence.MovieRepository;
import com.greedy.chinema.persistence.MovieStorage;

// JUnit 5용 import 문으로 변경
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5용 Assertions로 변경
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DisplayName("MovieService 핵심 기능 테스트")
class MovieServiceTest {

    private static final String TEST_DB_PATH = "test_db.txt";

    private MovieService movieService;
    private MovieRepository movieRepository;
    private MovieStorage movieStorage;

    // @Before -> @BeforeEach 로 변경
    @BeforeEach
    @DisplayName("각 테스트 전에 깨끗한 테스트 환경을 설정")
    void setUp() {
        movieStorage = new FileMovieStorage(TEST_DB_PATH);
        movieRepository = new MovieRepository(movieStorage);
        movieService = new MovieService(movieRepository);
    }

    // @After -> @AfterEach 로 변경
    @AfterEach
    @DisplayName("각 테스트 후에 임시 파일을 삭제하여 정리")
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_DB_PATH));
    }

    @Test
    @DisplayName("영화를 등록하면 파일에 정상적으로 저장되어야 한다")
    void registerMovie_shouldSaveMovieToFile() throws IOException {
        // Given
        Map<String, LocalDateTime> showtimes = new HashMap<>();
        showtimes.put("normal", LocalDateTime.parse("2025-10-26T10:00:00"));
        Movie newMovie = new Movie("테스트 영화", "테스트 감독", showtimes);

        // When
        movieService.registerMovie(newMovie);

        // Then
        Movie foundMovie = movieService.getMovieByTitle("테스트 영화");
        assertNotNull(foundMovie);
        assertEquals("테스트 감독", foundMovie.getDirector());

        List<String> lines = Files.readAllLines(Path.of(TEST_DB_PATH));
        assertEquals(1, lines.size());
        assertTrue(lines.get(0).contains("title:테스트 영화"));
        assertTrue(lines.get(0).contains("director:테스트 감독"));
    }

    @Test
    @DisplayName("좌석을 예매하면 예매 상태가 파일에 반영되어야 한다")
    void bookSeatAndUpdate_shouldReflectStateInFile() {
        // Given
        Map<String, LocalDateTime> showtimes = new HashMap<>();
        showtimes.put("normal", LocalDateTime.parse("2025-10-26T10:00:00"));
        Movie movie = new Movie("예매용 영화", "예매 감독", showtimes);
        movieService.registerMovie(movie);

        // When
        boolean isBooked = movieService.bookSeatAndUpdate(movie, "normal", 0, 0);

        // Then
        assertTrue(isBooked);

        MovieRepository newRepository = new MovieRepository(new FileMovieStorage(TEST_DB_PATH));
        Movie loadedMovie = newRepository.findByTitle("예매용 영화");

        boolean result = loadedMovie.bookSeat("normal", 0, 0);
        assertFalse(result, "이미 예매된 좌석이므로 다시 예매되면 안됨");
    }

    @Test
    @DisplayName("이미 예매된 좌석을 다시 예매하면 실패해야 한다")
    void bookSeat_onAlreadyBookedSeat_shouldFail() {
        // Given
        Map<String, LocalDateTime> showtimes = new HashMap<>();
        showtimes.put("vip", LocalDateTime.parse("2025-10-27T20:00:00"));
        Movie movie = new Movie("중복 예매 테스트", "중복 감독", showtimes);
        movieService.registerMovie(movie);

        movieService.bookSeatAndUpdate(movie, "vip", 2, 4);

        // When
        boolean secondAttempt = movieService.bookSeatAndUpdate(movie, "vip", 2, 4);

        // Then
        assertFalse(secondAttempt);
    }
}