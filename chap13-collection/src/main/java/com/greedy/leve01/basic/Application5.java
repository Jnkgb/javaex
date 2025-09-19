package com.greedy.leve01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Application5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> treeset=new TreeSet<>();
        while(true){
            System.out.print("단어 입력 ('exit' 입력 시 종료): ");
            String str=br.readLine();
            if (str.equals("exit")) {
                break;
            }
            else {
                treeset.add(str);
            }

        }
        System.out.println(treeset);
    }
}
