package com.aryan.designpatterns.behavioral.strategy;

import com.aryan.designpatterns.behavioral.strategy.strategies.PaymentStrategy;

import java.util.Scanner;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(int amount, Scanner sc) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy not set!");
        }
        strategy.pay(amount, sc);
    }
}
