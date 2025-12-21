package com.pearl.novdev.thread.banksync;

public class TransactionTask implements Runnable {
    private BankAccount account;
    private boolean deposit;

    public TransactionTask(BankAccount account, boolean deposit) {
        this.account = account;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        if (deposit) {
            account.deposit(200);
        } else {
            account.withdraw(150);
        }
    }
}
