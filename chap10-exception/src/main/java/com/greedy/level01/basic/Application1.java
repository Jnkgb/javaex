package com.greedy.level01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("분자 입력: ");
          int a=  Integer.parseInt(br.readLine());
            System.out.println("분모 입력 : ");
            int b=  Integer.parseInt(br.readLine());

            System.out.println("결과 : "+a/b);
        }catch (NumberFormatException e){
            System.out.println("오류 : 유효한 정수를 입력하세요.");
        }
        catch (ArithmeticException e){
            System.out.println("오류 : 0으로 나누는 것은 허용되지 않습니다.");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("실행이 완료되었습니다.");
    }
}
