package com.greedy.chinema.persistence;


public abstract class AbstractMovieType implements MovieType {

    @Override
    public void printSeat(int[][] seats) {
        if (seats == null) {
            System.out.println("좌석 정보가 없습니다.");
            return;
        }
        for (int i = 0; i < seats[0].length*4/2; i++) {
            System.out.print("=");
        }
        System.out.print("S C R E E N");
        for (int i = 0; i < seats[0].length*4/2; i++) {
            System.out.print("=");
        }
        System.out.print("\n\n\n");
        //System.out.println("================= S C R E E N =================");
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("%c열 ", 'A' + i);
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.printf("[%2d]", j + 1);
                }else {
                    System.out.print("[XX]");
                }
                if(j==(seats[i].length-1)/5||j==((seats[i].length-1)*4)/5){
                    System.out.print("         ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < seats[0].length*4+11; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    @Override
    public boolean bookSeat(int[][] seats, int row, int col) {
        if (seats == null || row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            return false;
        }
        if (seats[row][col] == 0) {
            seats[row][col] = 1;
            return true;
        }
        return false;
    }

    @Override
    public abstract int[][] getSeat(String movieType);
}