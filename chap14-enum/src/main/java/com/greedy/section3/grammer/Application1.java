package com.greedy.section3.grammer;

public class Application1 {
    public static void main(String[] args) {
        for(EnumType enumType : EnumType.values()){
            System.out.println(enumType);
        }
        for(EnumType enumType : EnumType.values()){
            if( enumType== EnumType.valueOf("JAVA")){
                System.out.println("valueOf="+enumType);
            }
        }
        for (EnumType enumType : EnumType.values()){
            System.out.println(enumType.ordinal());
        }

        System.out.println(EnumType.valueOf("JAVA"));
    }
}
