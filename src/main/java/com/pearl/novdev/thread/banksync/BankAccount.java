package com.pearl.novdev.thread.banksync;

public class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " deposited " + amount + ", balance = " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " withdrew " + amount + ", balance = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " insufficient balance");
        }
    }

    public int getBalance() {
        return balance;
    }
}
