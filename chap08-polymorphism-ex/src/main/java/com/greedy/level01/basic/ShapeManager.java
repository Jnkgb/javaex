package com.greedy.level01.basic;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index=0;

    public void addShape(Shape shape) {
        if (index == shapes.length) {
            Shape[] temp = new Shape[shapes.length * 2];
            for (int i = 0; i < index; i++) {
                temp[i] = shapes[i];
            }
            shapes = temp;
        }
        shapes[index++] = shape;

    }

    public void removeShape(Shape shape) {
        for(int i=0;i<index;i++){
            if(shapes[i].equals(shape)){
                shapes[i]=null;
                for(int j=i;j<index-1;j++){
                    shapes[j]=shapes[j+1];
                }
               shapes[index-1]=null;
                index--;
            }
        }
        /* 배열에서 전달 된 Shape를 찾아 제거. 단, 제거 된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
    }

    public void printAllShapes() {
        for (int i = 0; i < index; i++) {
            System.out.print("Shape : ");
            for (int j = 0; j < 3; j++) {
                if(shapes[i] instanceof Triangle) {
                    System.out.println("Triangle");
                    break;
                } else if(shapes[i] instanceof Rectangle) {
                    System.out.println("Rectangle");
                    break;
                } else if(shapes[i] instanceof Circle) {
                    System.out.println("Circle");
                    break;
                }
            }
            System.out.println("Area : "+shapes[i].calculateArea());
            System.out.println("Perimeter : "+shapes[i].calculatePerimeter());
        }
    }

    public double getTotalArea() {
        /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
        double sum=0;
        for (int i = 0; i < index; i++) {
            sum+=shapes[i].calculateArea();
        }
        return sum;
    }

    public double getTotalPerimeter() {
        /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
        double sum=0;
        for (int i = 0; i < index; i++) {
            sum+=shapes[i].calculatePerimeter();
        }
        return sum;
    }
}
