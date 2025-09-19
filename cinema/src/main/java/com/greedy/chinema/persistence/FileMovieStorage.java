package com.greedy.chinema.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileMovieStorage implements MovieStorage {
    private static final String FILE_PATH="C:/javaex/cinema/src/main/java/com/greedy/chinema/db/db.txt";
    @Override
    public List<String> getMovies(){
        File file = new File(FILE_PATH);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // 파일의 각 줄을 순회
            while ((line = br.readLine()) != null) {
                String title = line.split("/")[0].split(":")[1];
                System.out.println(title);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
