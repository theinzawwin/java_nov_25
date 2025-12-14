package com.pearl.novdev.oop.abstraction;

public abstract class AbstractAccount {
    protected String accountNumber;
    protected double balance;

    public AbstractAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstract method (must be implemented by child classes)
    public abstract void calculateInterest();

    // Concrete method
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Implementing abstract class

