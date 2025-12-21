package com.pearl.novdev.thread.banksync;

public class BankSyncMain {

    public static void main(String[] args){
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new TransactionTask(account, true), "User-1");
        Thread t2 = new Thread(new TransactionTask(account, false), "User-2");
        Thread t3 = new Thread(new TransactionTask(account, true), "User-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
