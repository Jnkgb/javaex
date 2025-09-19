package com.greedy.leve01.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner st = new Scanner(System.in);

        int count=0;
        boolean flag=true;
        while(flag) {
            System.out.print("학생성적 : ");
            list.add(sc.nextInt());
            System.out.print("추가입력 하려면 y: ");
            String sw=st.nextLine();
            if(sw.equals("Y")||sw.equals("y")) {
                flag=true;
            }else{
                break;
            }
            count++;
        }
        double  sum=0;
        for(int i=0;i<list.size();i++) {
            sum+=list.get(i);
        }
        System.out.println((sum/list.size()));
    }
}
