package com.pearl.novdev.oop;

import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args){
        BankAccount bc = new BankAccount("1111","Zaw Zaw",50000);
        BankAccount bc2 = new BankAccount("22222","Hein Htet",50000);
        Scanner sc =new Scanner(System.in);
        int option = 1;
        do{
            System.out.println("Please choose which function to do. Deposit = 1, Withdraw = 2, Check Balance = 3, Continue = 4, Account Info = 5, Exit = 0 ");
            option = Integer.parseInt(sc.nextLine());
            switch(option){
                case 1->{
                    System.out.println("Please enter a deposit amount");
                    double amount = Double.parseDouble( sc.nextLine());
                    bc.deposit(amount);
                    System.out.println("After Deposit, your balance is "+bc.getBalance());
                }
                case 2->{
                    System.out.println("Please enter a transfer amount");
                    double amount = Double.parseDouble(sc.nextLine());
                    bc.withdraw(amount);
                    System.out.println("After Withdraw, your balance is "+bc.getBalance());
                }
                case 3-> {
                    bc.displayBalance();
                }
                case 4->{
                    bc.displayAccountInfo();
                }
            }
          //  System.out.println("Do you want to continue?");
           // option = Integer.parseInt(sc.nextLine());
        }while(option!=0);
    }
}
