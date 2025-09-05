package com.aryan.designpatterns.structural.decorator.decorators;

import com.aryan.designpatterns.structural.decorator.Coffee;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    public abstract String getDecoratorName();
}
