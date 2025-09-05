package com.aryan.designpatterns.structural.decorator.decorators;

import com.aryan.designpatterns.structural.decorator.Coffee;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public int getCost() {
        return super.getCost() + 20;
    }

    @Override
    public String getDecoratorName() {
        return "Sugar Rs 20?";
    }
}
