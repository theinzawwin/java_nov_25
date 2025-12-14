package com.pearl.novdev.oop.polymorphism;

import java.util.Scanner;

public class PaymentMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Choose Your Payment k= KBZPay, w= WavePay, m= MPUPay and Default Payment is Cash Pay");
        Payment payment;
        char c=sc.nextLine().charAt(0);
        payment = switch (c) {
            case 'k' -> new KBZPay();
            case 'w' -> new WavePay();
            case 'm' -> new MPUPay();
            default -> new CashPay();
        };
        payment.pay(2000);
    }
}
