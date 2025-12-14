package com.pearl.novdev.designpattern.strategy;

public class Main {

    public static void main(String[] args){
        PaymentContext context = new PaymentContext(new CardPayment());
        context.pay(5000);

        context.changeStrategy(new KbzPayPayment());
        context.pay(2000);

        context.changeStrategy(new WavePayPayment());
        context.pay(1500);
    }
}
