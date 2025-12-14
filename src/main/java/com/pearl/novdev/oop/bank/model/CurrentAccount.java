package com.pearl.novdev.oop.bank.model;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountId, double balance, double overdraftLimit) {
        super(accountId, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }
        if (balance + overdraftLimit < amount) {
            System.out.println("Withdrawal denied! Exceeds overdraft limit.");
            return;
        }
        balance -= amount;
        System.out.println(amount + " withdrawn. New balance: " + balance);
    }

    @Override
    public void applyMonthlyInterest() {
        // Current accounts do not earn interest
        System.out.println("Current Account does not have interest.");
    }

    @Override
    public void printDetails() {
        System.out.println("=== Current Account ===");
        super.printDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}