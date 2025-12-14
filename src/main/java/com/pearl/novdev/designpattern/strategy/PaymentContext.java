package com.pearl.novdev.designpattern.strategy;

import com.pearl.novdev.oop.polymorphism.Payment;

public class PaymentContext {

    private PaymentStrategy strategy;
    public PaymentContext(PaymentStrategy strategy){
        this.strategy = strategy;
    }
    public void changeStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void pay(double amount){
        strategy.pay(amount);
    }
}
