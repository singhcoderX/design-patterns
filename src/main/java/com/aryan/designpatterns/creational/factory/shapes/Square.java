package com.aryan.designpatterns.creational.factory.shapes;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }

    @Override
    public String getName() {
        return "Square";
    }
}
