package com.aryan.designpatterns.creational.factory;

import com.aryan.designpatterns.creational.factory.shapes.Circle;
import com.aryan.designpatterns.creational.factory.shapes.Shape;
import com.aryan.designpatterns.utils.XmlClassLoader;

import java.util.Map;
import java.util.Scanner;

public class ShapeFactory {
    private static Map<Integer, Shape> shapes = null;

    static {
        shapes = XmlClassLoader.loadClassesFromXml("shapes.xml", "shape", Shape.class);
        if (shapes == null || shapes.isEmpty()) {
            throw new RuntimeException("No shapes loaded from XML. Please check shapes.xml!");
        }
    }

    public static Shape getShape(Scanner scanner) {
        System.out.println("\nAvailable Shapes:");
        for (Map.Entry<Integer, Shape> entry : shapes.entrySet()) {
            Integer key = entry.getKey();
            Shape shape = entry.getValue();
            System.out.println("\t " + key + ". " + shape.getName());
        }
        System.out.print("Enter shape number to draw: ");
        int shapeType = scanner.nextInt();
        if (shapes.containsKey(shapeType)) {
            return shapes.get(shapeType);
        } else {
            System.out.println("Invalid choice! Returning null.");
            return null;
        }
    }
}
