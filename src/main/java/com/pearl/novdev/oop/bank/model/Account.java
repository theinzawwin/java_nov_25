package com.pearl.novdev.oop.bank.model;

public abstract class Account {
    private String accountId;
    protected double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }

    public abstract void withdraw(double amount);

    public abstract void applyMonthlyInterest();

    public void printDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Balance: " + balance);
    }
}
