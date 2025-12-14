package com.pearl.novdev.oop.ecom_discount;

public class DiscountMain {
    public static void main(String[] args){
        Customer[] customers = {
          new Customer(),
          new RegularCustomer(),
          new PremiumCustomer(),
          new VIPCustomer()
        };

        double amount = 100000;

        for (Customer c : customers) {
            System.out.println(c.getClass().getSimpleName()
                    + " discount: " + c.getDiscount(amount));
        }
    }
}
