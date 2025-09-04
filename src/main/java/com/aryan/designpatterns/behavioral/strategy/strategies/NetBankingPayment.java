package com.aryan.designpatterns.behavioral.strategy.strategies;

import java.util.Scanner;

public class NetBankingPayment implements PaymentStrategy {
    public static final Integer ID = 3;

    private String bankName;
    private String accountNumber;
    private String ifscCode;

    public NetBankingPayment() {
        System.out.println("Net Banking Payment Gateway Initiated");
    }

    @Override
    public void pay(int amount, Scanner sc) {
        System.out.println("Enter Bank Name: ");
        bankName = sc.nextLine();
        System.out.println("Enter Account Number: ");
        accountNumber = sc.nextLine();
        System.out.println("Enter IFSC Code: ");
        ifscCode = sc.nextLine();

        // Simulate payment process
        System.out.println("Processing net banking payment...");
        System.out.println("Amount " + amount + " paid successfully using Net Banking from " + bankName + " account " + accountNumber + ".");
    }

    @Override
    public String getSimpleName() {
        return "Net Banking";
    }
}