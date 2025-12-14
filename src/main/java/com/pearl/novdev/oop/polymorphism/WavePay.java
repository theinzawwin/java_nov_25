package com.pearl.novdev.oop.polymorphism;

public class WavePay implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paying with WavePay for Amount = "+amount);
    }
}
