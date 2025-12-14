package com.pearl.novdev.exception;

public class ThrowThrowsExample {
//throws IllegalArgumentException
    static void checkAge(int age) throws IllegalArgumentException{
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
    }

    public static void main(String[] args) {
        try{
            checkAge(17);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught=> "+e.getMessage());
        }


    }
}
