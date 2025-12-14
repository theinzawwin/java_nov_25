package com.pearl.novdev.oop.abstraction;

public class FixedDepositAccount extends AbstractAccount {
    private double interestRate;
    private int termMonths;

    public FixedDepositAccount(String accountNumber, double balance,
                               double interestRate, int termMonths) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
        this.termMonths = termMonths;
    }

    // Implementing abstract method
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate * termMonths / 12 / 100;
        System.out.println("Fixed Deposit Interest: $" + interest);
    }
}
