package com.example.shape;

public class Main{
    public static void main(String[] args) {

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        circle.printInfo();
        System.out.println("Circle area: " + circle.calculateArea());

        rectangle.printInfo();
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}