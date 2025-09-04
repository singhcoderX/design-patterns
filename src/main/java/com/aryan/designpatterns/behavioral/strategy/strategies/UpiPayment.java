package com.aryan.designpatterns.behavioral.strategy.strategies;

import com.aryan.designpatterns.behavioral.strategy.PaymentStrategyFactory;

import java.util.Scanner;

public class UpiPayment implements PaymentStrategy {
    public static final Integer ID = 2;

    public UpiPayment() {
        System.out.println("UPI Payment Gateway Initiated");
    }

    @Override
    public void pay(int amount, Scanner scanner) {
        System.out.println("Enter Payment ID: ");
        String upiId = scanner.nextLine();

        System.out.println("Processing upi payment...");
        System.out.println("Amount " + amount + " paid successfully using UPI: " + upiId);
    }

    @Override
    public String getSimpleName() {
        return "UPI";
    }
}
