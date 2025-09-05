package com.aryan.designpatterns.structural.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public int getCost() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
