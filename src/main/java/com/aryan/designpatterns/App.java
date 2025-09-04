package com.aryan.designpatterns;

import com.aryan.designpatterns.behavioral.strategy.PaymentContext;
import com.aryan.designpatterns.behavioral.strategy.PaymentStrategyFactory;
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
        PaymentStrategy strategy = PaymentStrategyFactory.getPaymentStrategy(scanner);
        if (strategy == null) {
            return;
        }
        context.setPaymentStrategy(strategy);
        System.out.println("Enter amount to pay:");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume newline
        context.payAmount(amount, scanner);
    }
}