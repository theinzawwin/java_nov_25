package com.pearl.novdev.exception;

public class FinallyExample {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            //String name=null;
            //System.out.println("Name Upper="+name.toUpperCase());
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[4]); // ArrayIndexOutOfBoundsException

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!");
        } catch(NullPointerException npe) {
            System.out.println("Null pointer exception");
        }

        finally {
            System.out.println("Finally block should be run finally");
        }
    }
}
