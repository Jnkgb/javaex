package com.greedy.level01.basic;

import java.io.*;

public class Application2 {
    public static void main(String[] args) throws IOException {
        FileReader file = null;
        FileWriter file2=null;
        System.out.println("원본 파일의 이름을 입력하세요 : ");
        try( BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
            String firstFile=br.readLine();
            file=new FileReader(firstFile);
            System.out.println("두번쨰 파일의 이름을 입력하세요 : ");
            char [] carr=new char[(int) new File(firstFile).length()];
            file.read(carr);
            String secondFile=br.readLine();
            file2=new FileWriter(secondFile);
            file2.write('W');
        }catch (FileNotFoundException e){
            System.out.println("파일을 찾지 못했습니다.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        /* ----- 입력 예시 -----
         *
         * (원본 파일이 존재 하는 경우)
         * 원본 파일의 이름을 입력하세요 : origin.txt
         * 복사 파일의 이름을 입력하세요 : copy.txt
         *
         * ----- 출력 예시 -----
         *
         * 파일 복사가 성공적으로 완료 되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * (원본 파일이 존재하지 않는 경우)
         * 원본 파일의 이름을 입력하세요 : origin2.txt
         * 복사 파일의 이름을 입력하세요 : copy2.txt
         *
         * ----- 출력 예시 -----
         *
         * 오류 : origin2.txt (지정된 파일을 찾을 수 없습니다)
         *
         */

    }
}