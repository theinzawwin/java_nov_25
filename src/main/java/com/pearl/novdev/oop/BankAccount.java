package com.pearl.novdev.oop;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accNo){
        this.accountNumber = accNo;
    }
    public String getAccountHolder(){
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
        }else{
            System.out.println("Your balance is insufficient to withdraw");
        }
    }
    public void displayBalance(){
        System.out.println("Balance is "+balance);
    }
    public void displayAccountInfo(){
        System.out.println("Account Number= "+accountNumber);
        System.out.println("Account Holder= "+accountHolder);
    }
}
