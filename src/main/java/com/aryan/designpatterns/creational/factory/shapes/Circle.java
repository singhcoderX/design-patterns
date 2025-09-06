package com.aryan.designpatterns.creational.factory.shapes;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public String getName() {
        return "Circle";
    }
}
