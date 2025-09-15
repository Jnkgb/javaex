package com.greedy.level01.basic;

public class Circle extends Shape implements Resizable  {
    private double radius ;

    public Circle(int radius) {
        super();
        this.radius=radius;
    }

    @Override
    double calculateArea() {
        return radius * radius*Math.PI;

    }

    @Override
    double calculatePerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public void resize(double factor) {
        this.radius *= factor;
    }
}
