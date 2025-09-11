package com.greedy.level01.basic.student.run;

import com.greedy.level01.basic.student.model.dto.StudentDto;

import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        StudentDto[] students=new StudentDto[10];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc=new Scanner(System.in);
        int count=0;
        String tf;
        do{
            System.out.print("학년 : ");
            int grade=sc.nextInt();
            System.out.print("반 : ");
            int classroom=sc.nextInt();
            System.out.print("이름 : ");
            String name=sc.next();
            System.out.print("국어점수 : ");
            int kor=sc.nextInt();
            System.out.print("영어점수 : ");
            int eng=sc.nextInt();
            System.out.print("수학점수 : ");
            int mat=sc.nextInt();

            students[count]=new StudentDto(grade,classroom,name,kor,eng,mat);

            bw.write("계속 추가할 겁니까 ? (y/n) :");
            bw.flush();
            tf=br.readLine();
            count++;
        }while(tf.equals("y")||tf.equals("Y"));
        for(int i=0;i<count;i++){
            System.out.println(students[i].getInformation()+" ,평균="+(students[i].getkor()+students[i].geteng()+students[i].getmath())/3);
        }
    }
}
