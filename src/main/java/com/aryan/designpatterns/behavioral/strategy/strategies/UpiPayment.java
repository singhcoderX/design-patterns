package com.aryan.designpatterns.behavioral.strategy.strategies;

import java.util.Scanner;

public class UpiPayment implements PaymentStrategy {
    public static final Integer ID = 2;

    private String upiId;

    public UpiPayment() {
        System.out.println("UPI Payment Gateway Initiated");
    }

    @Override
    public void pay(int amount, Scanner scanner) {
        System.out.println("Enter Payment ID: ");
        scanner.nextLine();

        System.out.println("Processing upi payment...");
        System.out.println("Amount " + amount + " paid successfully using UPI: " + upiId);
    }

    @Override
    public String getSimpleName() {
        return "UPI";
    }
}
