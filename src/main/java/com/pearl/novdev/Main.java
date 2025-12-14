package com.pearl.novdev;

public class Main {
    public static void main(String[] args) {
        int age = 8;
        final double pi = 3.142;

        if(age < 10){
            System.out.println("Child");
        }
        else if(age > 10 && age < 20){
            System.out.println("teenager");
        }
        else if(age > 20){
            System.out.println("Adult");
        }else{
            System.out.println("Under not conditions");
        }

    }
}