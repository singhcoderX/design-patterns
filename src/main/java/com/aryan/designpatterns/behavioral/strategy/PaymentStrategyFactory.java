package com.aryan.designpatterns.behavioral.strategy;

import com.aryan.designpatterns.behavioral.strategy.strategies.CreditCardPayment;
import com.aryan.designpatterns.behavioral.strategy.strategies.NetBankingPayment;
import com.aryan.designpatterns.behavioral.strategy.strategies.PaymentStrategy;
import com.aryan.designpatterns.behavioral.strategy.strategies.UpiPayment;
import com.aryan.designpatterns.utils.XmlClassLoader;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PaymentStrategyFactory {
    private static Map<Integer, PaymentStrategy> paymentStrategies = null;

    static {
        paymentStrategies =
                XmlClassLoader.loadClassesFromXml("payment-strategies.xml", "strategy", PaymentStrategy.class);

//        // Load XML from resources
//        InputStream is = PaymentStrategyFactory.class
//                .getClassLoader()
//                .getResourceAsStream("payment-strategies.xml");
//        if (is == null) {
//            throw new RuntimeException("payment-strategies.xml not found in resources folder!");
//        }
//
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder builder = dbf.newDocumentBuilder();
//            Document doc = (Document) builder.parse(is);
//
//            NodeList strategyList = doc.getElementsByTagName("strategy");
//            for (int i = 0; i < strategyList.getLength(); i++) {
//                Node node = strategyList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element element = (Element) node;
//                    int id = Integer.parseInt(element.getAttribute("id"));
//                    String className = element.getElementsByTagName("class").item(0).getTextContent();
//                    PaymentStrategy paymentStrategy = (PaymentStrategy) Class.forName(className).getDeclaredConstructor().newInstance();
//                    paymentStrategies.put(id, paymentStrategy);
//                }
//            }
//        } catch (ParserConfigurationException | IOException | SAXException | ClassNotFoundException |
//                 InvocationTargetException | InstantiationException | IllegalAccessException |
//                 NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
//
//        paymentStrategies.put(CreditCardPayment.ID, new CreditCardPayment());
//        paymentStrategies.put(UpiPayment.ID, new UpiPayment());
//        paymentStrategies.put(NetBankingPayment.ID, new NetBankingPayment());
    }

    public static void registerStrategy(Integer ID, PaymentStrategy strategy) {
        paymentStrategies.put(ID, strategy);
    }

    public static PaymentStrategy getPaymentStrategy(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose payment method:");
            for (Map.Entry<Integer, PaymentStrategy> entry : paymentStrategies.entrySet()) {
                Integer key = entry.getKey();
                PaymentStrategy strategy = entry.getValue();
                System.out.println("\t " + key + ". " + strategy.getSimpleName());
            }
            System.out.println("\t 0. Exit");
            System.out.print("Enter choice: ");
            int paymentChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (paymentChoice == 0) {
                exit = true;
                break;
            }

            PaymentStrategy strategy = paymentStrategies.get(paymentChoice);
            if (strategy != null) {
                return strategy;
            } else {
                System.out.println("\nInvalid choice.Try again.\n");
            }
        }
        return null;
    }
}
