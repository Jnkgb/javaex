package com.greedy.level01.basic;

import java.io.*;

public class Application1 {
    public static void main(String[] args) throws IOException {
        FileReader fr=null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            System.out.print("파일 이름을 입력세요 : ");

            String filename=br.readLine();
            fr=new FileReader(filename);
            char [] carr=new char[(int) new File(filename).length()];
            fr.read(carr);
           for (int i=0;i<carr.length;i++){
               System.out.print(carr[i]);
             //  if(carr[i]==)break;
           }
        }catch (FileNotFoundException e){
            System.out.println("해당 이름을 가진 파일은 없습니다.");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(fr!=null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
