package com.pearl.novdev.exception;

public class TryCatchExample {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            int result = 10 / 0; // This will cause ArithmeticException
            System.out.println(result);
            System.out.println("Hello Exception");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero!");
        }

    }
}
