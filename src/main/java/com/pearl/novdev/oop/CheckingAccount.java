package com.pearl.novdev.oop;

public class CheckingAccount  extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder,
                           double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolder, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    // Overriding withdraw method with overdraft capability
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= -overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}
