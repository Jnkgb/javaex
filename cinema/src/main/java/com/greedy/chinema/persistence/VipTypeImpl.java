package com.greedy.chinema.persistence;


public class VipTypeImpl extends AbstractMovieType {
    @Override
    public int[][] getSeat(String movieType) {
        return new int[20][26];
    }
}
