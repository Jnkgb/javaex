package com.greedy.chinema;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String password;
    private List<Movie> movies;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
