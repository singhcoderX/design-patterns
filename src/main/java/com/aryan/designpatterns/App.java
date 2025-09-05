package com.aryan.designpatterns;

import com.aryan.designpatterns.behavioral.strategy.PaymentContext;
import com.aryan.designpatterns.behavioral.strategy.PaymentStrategyFactory;
import com.aryan.designpatterns.behavioral.strategy.strategies.CreditCardPayment;
import com.aryan.designpatterns.behavioral.strategy.strategies.PaymentStrategy;
import com.aryan.designpatterns.behavioral.strategy.strategies.UpiPayment;
import com.aryan.designpatterns.behavioral.observer.YouTubeChannelSubject;
import com.aryan.designpatterns.behavioral.observer.ConcreteSubscriber;
import com.aryan.designpatterns.structural.decorator.Coffee;
import com.aryan.designpatterns.structural.decorator.SimpleCoffee;
import com.aryan.designpatterns.structural.decorator.SimpleCoffeeFactory;
import com.aryan.designpatterns.structural.decorator.decorators.MilkDecorator;
import com.aryan.designpatterns.structural.decorator.decorators.SugarDecorator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Java Design Patterns ===");

        while (!exit) {
            System.out.println("\nSelect a pattern to run:");
            System.out.println("1. Strategy Pattern");
            System.out.println("2. Observer Pattern");
            System.out.println("3. Decorator Pattern");
            // Future: 3. Singleton, etc.
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> runStrategyPattern(scanner);
                case 2 -> runObserverPattern(scanner);
                case 3 -> runDecoratorPattern(scanner);
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

    private static void runObserverPattern(Scanner scanner) {
        System.out.println("\n--- Observer Pattern Demo ---");
        System.out.print("Enter the YouTube channel name: ");
        String channelName = scanner.nextLine();
        YouTubeChannelSubject channel = new YouTubeChannelSubject(channelName);

        System.out.print("Enter number of subscribers to add: ");
        int numSubscribers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 1; i <= numSubscribers; i++) {
            String subscriberName = "Subscriber" + i;
            ConcreteSubscriber subscriber = new ConcreteSubscriber(subscriberName);
            channel.addSubscriber(subscriber);
            System.out.println(subscriberName + " subscribed to " + channelName);
        }

        System.out.print("Enter video title to upload: ");
        String videoTitle = scanner.nextLine();
        channel.uploadVideo(videoTitle);
    }

    private static void runDecoratorPattern(Scanner scanner) {
        System.out.println("\n--- Decorator Pattern Demo (Coffee Example) ---");

        Coffee coffee = SimpleCoffeeFactory.createCoffee(scanner);
        
        System.out.println("\nFinal Order: " + coffee.getDescription());
        System.out.println("Total Price: ₹" + coffee.getCost());
    }
}