package com.greedy.level01.basic;

public class Rectangle extends Shape implements Resizable{
    private double width;
    private double height;

    public Rectangle(int width  , int height) {
        super();
        this.width = width;
        this.height=height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return 2*width + 2*height;
    }

    @Override
    public void resize(double factor) {
        this.width *= factor;
        this.height *= factor;
    }
}
