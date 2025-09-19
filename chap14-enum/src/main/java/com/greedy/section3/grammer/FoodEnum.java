package com.greedy.section3.grammer;

public enum FoodEnum {
    MEAL_AN_BUTTER_KIMCHI_STEW("야ㅇ버터"),
   MEAL_MINT_SEAWEED_SOUP("ㅁㅣㄴ트 미역ㄱㅜㄱ") ,
    MEAL_BUNGEOPPANG_SUSHI ("붕어빵"),

    DRINK_RADISH_KIMCHI_LATTE(3) ,
    DRINK_WOOLUCK_SMOOTHIE (4),
    DRINK_RAW_CUTTLEFISH_SHAKE (5);

    //private final String nan;
    private final String name;

    private final int value;
        private final int va=5;
        FoodEnum(int value) {
        this.value = value;
        }
        public void printVar(){
            System.out.println(value);
        }

}
