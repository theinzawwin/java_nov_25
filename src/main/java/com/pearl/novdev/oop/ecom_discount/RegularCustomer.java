package com.pearl.novdev.oop.ecom_discount;

public class RegularCustomer extends Customer{

    @Override
    public double getDiscount(double totalAmount) {
        return totalAmount * 0.05; // 5% discount
    }
}
