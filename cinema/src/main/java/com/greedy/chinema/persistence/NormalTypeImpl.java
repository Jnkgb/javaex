package com.greedy.chinema.persistence;

public class NormalTypeImpl extends AbstractMovieType {
    @Override
    public int[][] getSeat(String movieType) {
        return new int[9][18];
    }
}