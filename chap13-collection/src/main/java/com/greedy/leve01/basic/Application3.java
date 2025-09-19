package com.greedy.leve01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Application3 {
    public static void main(String[] args) throws IOException {
        Queue<String> queue=new LinkedList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.print("대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'):");
            String str=br.readLine();
            if(str.equals("next")){
                if(queue.isEmpty()){
                    System.out.println("대기 고객이 없습니다.");
                }
                else{
                    System.out.println(queue.poll()+"고객님 차례입니다.");
                }

            }
            else if (str.equals("exit"))break;
            else{
                queue.add(str);
                System.out.println(str+" 고객님 대기 등록 되었습니다.");
            }
        }
    }
}
