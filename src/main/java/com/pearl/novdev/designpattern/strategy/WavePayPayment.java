package com.pearl.novdev.designpattern.strategy;

public class WavePayPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using WavePay.");
    }
}
