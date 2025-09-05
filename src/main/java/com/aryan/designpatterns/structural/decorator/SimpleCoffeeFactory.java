package com.aryan.designpatterns.structural.decorator;

import com.aryan.designpatterns.structural.decorator.decorators.CoffeeDecorator;
import com.aryan.designpatterns.structural.decorator.decorators.MilkDecorator;
import com.aryan.designpatterns.structural.decorator.decorators.SugarDecorator;
import com.aryan.designpatterns.utils.XmlClassLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class SimpleCoffeeFactory {
    private static Map<Integer, DecoratorInfo> decoratorOptions = new HashMap<>();

    static class DecoratorInfo {
        private final Function<Coffee, CoffeeDecorator> factory;
        private final String displayName;

        DecoratorInfo(Function<Coffee, CoffeeDecorator> factory, String displayName) {
            this.factory = factory;
            this.displayName = displayName;
        }
    }

    static {
        Map<Integer, Function<Coffee, CoffeeDecorator>> decoratorMap =
                XmlClassLoader.loadFunctionsFromXml(
                        "decorators.xml",        // XML file in resources
                        "decorator",             // element tag in XML
                        Coffee.class,            // input type
                        CoffeeDecorator.class    // return type
                );

        for (Map.Entry<Integer, Function<Coffee, CoffeeDecorator>> entry : decoratorMap.entrySet()) {
            Coffee dummyCoffee = new SimpleCoffee();
            String displayName = entry.getValue().apply(dummyCoffee).getDecoratorName();
            decoratorOptions.put(entry.getKey(), new DecoratorInfo(entry.getValue(), displayName));
        }
    }

    public static Coffee createCoffee(Scanner scanner) {
        Coffee coffee = new SimpleCoffee();
        while (true) {
            System.out.println("\nCurrent Order: " + coffee.getDescription());
            System.out.println("Current Price: ₹" + coffee.getCost());
            System.out.println("Add something?");
            for (Map.Entry<Integer, DecoratorInfo> entry : decoratorOptions.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().displayName);
            }
            System.out.println("0. Done");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }
            DecoratorInfo decoratorInfo = decoratorOptions.get(choice);
            if (decoratorInfo != null) {
                coffee = decoratorInfo.factory.apply(coffee);
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        return coffee;
    }
}
