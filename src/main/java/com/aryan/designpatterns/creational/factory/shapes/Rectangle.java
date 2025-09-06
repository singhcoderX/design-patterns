package com.aryan.designpatterns.creational.factory.shapes;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
