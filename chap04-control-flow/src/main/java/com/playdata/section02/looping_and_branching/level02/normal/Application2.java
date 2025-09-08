package com.playdata.section02.looping_and_branching.level02.normal;

public class Application2 {

    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        for (int i=97;i<123;i++){
            sb.append((char)i);
        }
        System.out.println(sb);
    }
}
