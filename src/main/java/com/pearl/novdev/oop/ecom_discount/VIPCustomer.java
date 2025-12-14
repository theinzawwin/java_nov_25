package com.pearl.novdev.oop.ecom_discount;

public class VIPCustomer extends Customer{
    @Override
    public double getDiscount(double totalAmount) {
        return totalAmount * 0.20; //  20% Discount
    }
}
