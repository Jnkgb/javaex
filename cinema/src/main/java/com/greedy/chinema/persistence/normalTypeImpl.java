package com.greedy.chinema.persistence;

public class normalTypeImpl implements MovieType {
    @Override
    public int[][] getSeat(String movieType) {
        return new int[15][23];
    }
    @Override
    public void printSeat() {

    }

}