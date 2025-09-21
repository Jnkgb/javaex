package com.greedy.chinema.persistence;

public interface MovieType {
    int [][]   getSeat(String movieType);
    void printSeat(int[][] seat);

    boolean bookSeat(int[][] seats, int row, int col);
}
