package com.pearl.novdev.oop.polymorphism;

public class KBZPay implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Paying with KBZPay for Amount = "+amount);
    }
}
