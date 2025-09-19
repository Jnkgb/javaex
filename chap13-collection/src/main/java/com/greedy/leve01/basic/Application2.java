package com.greedy.leve01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Application2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list=new LinkedList<>();
        int a=0;
        while (true) {
            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) :");
            String s;
            s = br.readLine();
            list.add(s);
            if (list.size() == 6) {
               list.removeFirst();
            }
            System.out.println(list);
        }

    }
}
