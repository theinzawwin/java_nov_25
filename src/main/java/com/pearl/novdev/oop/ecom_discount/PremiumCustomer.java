package com.pearl.novdev.oop.ecom_discount;

public class PremiumCustomer extends Customer{
    @Override
    public double getDiscount(double totalAmount) {
        return totalAmount * 0.10; // 10% Discount
    }
}
