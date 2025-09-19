package com.greedy.chinema.persistence;

public class VipTypeImpl implements MovieType{
    @Override
    public int [][] getSeat(String movieType){
        return new int[30][46];
    }
    @Override
    public void printSeat() {

    }
}
