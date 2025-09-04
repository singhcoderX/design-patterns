package com.aryan.designpatterns.behavioral.strategy;

import com.aryan.designpatterns.behavioral.strategy.strategies.CreditCardPayment;
import com.aryan.designpatterns.behavioral.strategy.strategies.UpiPayment;

public class StrategyPatternDemo {
    public static void run() {
        System.out.println("\n--- Strategy Pattern Demo ---");

        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012"));
        context.payAmount(500);

        context.setPaymentStrategy(new UpiPayment("aryan@upi"));
        context.payAmount(300);
    }
}
