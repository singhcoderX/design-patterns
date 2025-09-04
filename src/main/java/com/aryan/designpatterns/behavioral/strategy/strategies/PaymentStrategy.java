package com.aryan.designpatterns.behavioral.strategy.strategies;

import java.util.Scanner;

public interface PaymentStrategy {
    public void pay(int amount, Scanner scanner);

    public String getSimpleName();
}
