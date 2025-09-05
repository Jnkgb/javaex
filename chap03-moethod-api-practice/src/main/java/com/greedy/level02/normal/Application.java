package com.greedy.level02.normal;

public class Application {
    public static void main(String[] args) {
        RandomMaker randomMaker=new RandomMaker();
        System.out.println(randomMaker.randomNumber(-35,-34));
        System.out.println(randomMaker.randomUpperAlphabet(10));
        System.out.println(randomMaker.rockPaperScissors());
        System.out.println(randomMaker.tossCoin());
    }
}
