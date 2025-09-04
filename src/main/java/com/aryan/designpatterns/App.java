package com.aryan.designpatterns;

import com.aryan.designpatterns.behavioral.strategy.PaymentContext;
import com.aryan.designpatterns.behavioral.strategy.strategies.CreditCardPayment;
import com.aryan.designpatterns.behavioral.strategy.strategies.PaymentStrategy;
import com.aryan.designpatterns.behavioral.strategy.strategies.UpiPayment;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Java Design Patterns ===");

        while (!exit) {
            System.out.println("\nSelect a pattern to run:");
            System.out.println("1. Strategy Pattern");
            // Future: 2. Observer Pattern, 3. Singleton, etc.
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> runStrategyPattern(scanner);
                case 0 -> {
                    System.out.println("Exiting program. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }

    private static void runStrategyPattern(Scanner scanner) {
        System.out.println("\n--- Strategy Pattern Demo ---");

        PaymentContext context = new PaymentContext();

        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.print("Enter choice: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter amount to pay: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PaymentStrategy strategy;
        switch (paymentChoice) {
            case 1 -> {
                System.out.print("Enter Credit Card number: ");
                String cardNumber = scanner.nextLine();
                strategy = new CreditCardPayment(cardNumber);
            }
            case 2 -> {
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                strategy = new UpiPayment(upiId);
            }
            default -> {
                System.out.println("Invalid payment method!");
                return;
            }
        }

        context.setPaymentStrategy(strategy);
        context.payAmount(amount);
    }
}