package com.pearl.novdev.oop.polymorphism;

public class MPUPay implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paying with MPU Card for Amount = "+amount);
    }
}
