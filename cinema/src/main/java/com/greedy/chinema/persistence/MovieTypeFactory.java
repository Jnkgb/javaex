package com.greedy.chinema.persistence;

public class MovieTypeFactory {

    public static MovieType create(String movieType) {
        switch (movieType.toLowerCase()) {
            case "normal":
                return new NormalTypeImpl();
            case "vip":
                return new VipTypeImpl();
            default:
                throw new IllegalArgumentException("지원하지 않는 상영관 타입입니다: " + movieType);
        }
    }
}