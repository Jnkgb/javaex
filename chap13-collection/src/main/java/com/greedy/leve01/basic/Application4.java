package com.greedy.leve01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Application4 {
    public static void main(String[] args) throws IOException {
        HashSet<String> hset= new HashSet<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.print("학생 ID 입력('exit' 입력 시 종료): ");
            String str=br.readLine();

            if (str.equals("exit")){
                System.out.println(hset);
                break;
            }
            else if(!hset.add(str)){
                System.out.println("이미 등록된 ID입니다.");
            }
            else{
                System.out.println("ID가 추가 되었습니다.");
            }
        }
    }
}