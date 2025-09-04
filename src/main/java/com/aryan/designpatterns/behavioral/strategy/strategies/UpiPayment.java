package com.aryan.designpatterns.behavioral.strategy.strategies;

public class UpiPayment implements PaymentStrategy {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI: " + upiId);
    }
}
