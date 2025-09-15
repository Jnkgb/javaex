package com.greedy.level01.basic;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("----- 입력 예시 ----- ");
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();
        String[] store = new String[str.length()];
        System.out.println("----- 출력 예시 ----- ");
        System.out.println("----- 입력 예시 ----- ");
        sb.append(str);
       // System.out.println(str);
        int[] result = new int[str.length()];
        int count = 0;
        String tt = str.replaceAll("[가-힣]", " ");
        String match = "[^0-9]";
        str = str.replaceAll(match, " ");
      //  System.out.println(tt);
        for (String st : tt.split(" ")) {
            boolean tf = false;
            String sw=st.toLowerCase();
            for (int i = 0; i < count; i++) {
                if (sw.equals(store[i])) {
                    result[i] += 1;
                    tf = true;
                }
            }
            if (!tf) {
                store[count] = sw;
                result[count] += 1;
            }
            count++;
        }
        for (int i = 0; i < count; i++) {
            if(store[i]==null)break;
            System.out.println(store[i]+":"+result[i]);
        }
    }
}

