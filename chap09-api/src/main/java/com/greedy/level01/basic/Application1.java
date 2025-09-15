package com.greedy.level01.basic;

import java.util.Locale;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        System.out.println("----- 입력 예시 -----");
        System.out.print("문자열 입력 : ");
        sb.append(sc.nextLine());

        String str=sb.toString();
        System.out.println();
        int count=0;
        System.out.println("----- 출력 예시 -----");
        System.out.print("변환된 문자열 : ");
        for(String st :str.split(" ")){
            String one=st.substring(0,1);
            String up=one.toUpperCase();
            System.out.print(up);
            if (st.length()>1) {
                System.out.print(st.substring(1, st.length()));
            }
            System.out.print(" ");
            count++;
        }
        System.out.println();
        System.out.println("총 단어 개수: "+count);

    }


}
