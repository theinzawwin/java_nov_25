package com.pearl.novdev.oop.bank.model;

public class SavingAccount extends Account {
    private double interestRate; // e.g., 0.03 = 3%

    public SavingAccount(String accountId, double balance, double interestRate) {
        super(accountId, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        System.out.println(amount + " withdrawn. New balance: " + balance);
    }

    @Override
    public void applyMonthlyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest + ". New balance: " + balance);
    }

    @Override
    public void printDetails() {
        System.out.println("=== Saving Account ===");
        super.printDetails();
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}