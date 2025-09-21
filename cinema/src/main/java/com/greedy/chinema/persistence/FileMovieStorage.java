package com.greedy.chinema.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.greedy.chinema.Movie;
import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;


import com.greedy.chinema.Movie;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileMovieStorage implements MovieStorage {
    private final String filePath;

    public FileMovieStorage() {
        this.filePath = "/Users/insu/javapj/javaex-main/cinema/src/main/java/com/greedy/chinema/db/db.txt";
    }

    public FileMovieStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Movie> loadMovies() {
        List<Movie> movies = new ArrayList<>();
        File file = new File(this.filePath);
        if (!file.exists()) return movies;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("/");
                String title = null;
                String director = null;
                Map<String, LocalDateTime> showtimes = new HashMap<>();
                Map<String, String> seatData = new HashMap<>();

                for (String part : parts) {
                    String[] kv = part.split(":", 2);
                    if (kv.length == 2) {
                        String key = kv[0];
                        String value = kv[1];
                        switch (key) {
                            case "title": title = value; break;
                            case "director": director = value; break;
                            case "showtimes":
                                for (String timeEntry : value.split(";")) {
                                    String[] ts = timeEntry.split(",", 2);
                                    if (ts.length == 2) showtimes.put(ts[0], LocalDateTime.parse(ts[1]));
                                }
                                break;
                            case "seats":
                                for (String seatEntry : value.split(";")) {
                                    String[] ss = seatEntry.split(",", 2);
                                    if (ss.length == 2) seatData.put(ss[0], ss[1]);
                                }
                                break;
                        }
                    }
                }
                if (title != null) {

                    movies.add(new Movie(title, director, showtimes, seatData));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public void saveMovies(List<Movie> movies) {
        try {
            File file = new File(this.filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) parentDir.mkdirs();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
                for (Movie movie : movies) {

                    String showtimesStr = movie.getReleaseDate().entrySet().stream()
                            .map(entry -> entry.getKey() + "," + entry.getValue())
                            .collect(Collectors.joining(";"));

                    String seatsStr = movie.getSeatMaps().entrySet().stream()
                            .map(entry -> {
                                StringBuilder sb = new StringBuilder();
                                for (int[] row : entry.getValue()) {
                                    for (int seat : row) sb.append(seat);
                                }
                                return entry.getKey() + "," + sb.toString();
                            })
                            .collect(Collectors.joining(";"));

                    String line = String.format("title:%s/director:%s/showtimes:%s/seats:%s",
                            movie.getTitle(), movie.getDirector(), showtimesStr, seatsStr);

                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}