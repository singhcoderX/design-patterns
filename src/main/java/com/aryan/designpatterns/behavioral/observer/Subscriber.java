package com.aryan.designpatterns.behavioral.observer;

public interface Subscriber {
    void update(String videoTitle);

    String getName();
}
