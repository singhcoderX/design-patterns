package com.aryan.designpatterns.behavioral.strategy.strategies;

import com.aryan.designpatterns.behavioral.strategy.PaymentStrategyFactory;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {
    public static final Integer ID = 1;
    
    @Override
    public void pay(int amount, Scanner sc) {
        System.out.println("Enter Credit Card Number: ");
        String cardNumber = sc.nextLine();
        System.out.println("Processing upi payment...");
        System.out.println("Amount " + amount + " paid successfully using Credit Card: " + cardNumber);
    }

    public CreditCardPayment() {
        System.out.println("Credit Card Payment Gateway Initiated");
    }

    @Override
    public String getSimpleName() {
        return "Credit Card";
    }
}
