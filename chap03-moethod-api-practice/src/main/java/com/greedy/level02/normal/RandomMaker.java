package com.greedy.level02.normal;

public class RandomMaker {
    public int randomNumber(int min,int max){
        return ((int)(Math.random()*(max-min+1))+min);
    }
    public String randomUpperAlphabet(int length){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
           int str=(int)(Math.random()*26)+65;
           sb.append((char)str);
        }
        return sb.toString();
    }
    public String rockPaperScissors(){
        int a=(int)(Math.random()*3)+1;
        String rockpaperScissors="";
        if (a==1){
            rockpaperScissors="Rock";
        }
        else if (a==2){
            rockpaperScissors="Paper";
        }
        else if (a==3){
            rockpaperScissors="Scissors";
        }

        return rockpaperScissors;
    }
    public String tossCoin(){
        String tossCoin="";
        int a=(int)(Math.random()*2);
        if (a==1){
            tossCoin="Front";
        }
        else if (a==0){
            tossCoin="Back";
        }
        return tossCoin;
    }
}
