package com.pearl.novdev.oop;

public class SavingsAccount  extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance,double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }
    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }

    // Overriding parent method
    @Override
    public void displayBalance() {
        super.displayBalance();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
