package com.pearl.novdev.exception;

public class MultiCatchExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            String text = null;
            System.out.println(text.length()); // NullPointerException
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error occurred.");
        } catch (NullPointerException e) {
            System.out.println("Null pointer error occurred.");
        }
    }
}
