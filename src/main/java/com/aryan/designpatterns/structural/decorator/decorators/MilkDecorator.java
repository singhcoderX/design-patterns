package com.aryan.designpatterns.structural.decorator.decorators;

import com.aryan.designpatterns.structural.decorator.Coffee;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.coffee.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public String getDecoratorName() {
        return "Milk Rs 30?";
    }
}
