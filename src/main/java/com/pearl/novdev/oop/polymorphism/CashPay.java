package com.pearl.novdev.oop.polymorphism;

public class CashPay implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("On Cash Paying for Amount = "+amount);
    }
}
