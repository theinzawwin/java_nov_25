package com.pearl.novdev.designpattern.strategy;

public class KbzPayPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using KBZPay.");
    }
}
