package com.aryan.designpatterns.behavioral.observer;

public class ConcreteSubscriber implements Subscriber {
    private final String name;

    public ConcreteSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received notification: New video uploaded - " + videoTitle);
    }

    @Override
    public String getName() {
        return name;
    }
}
