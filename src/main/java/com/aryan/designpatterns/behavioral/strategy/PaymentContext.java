package com.aryan.designpatterns.behavioral.strategy;

import com.aryan.designpatterns.behavioral.strategy.strategies.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy not set!");
        }
        strategy.pay(amount);
    }
}
