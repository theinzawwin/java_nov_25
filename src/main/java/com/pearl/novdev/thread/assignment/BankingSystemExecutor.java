package com.pearl.novdev.thread.assignment;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition sufficientFunds = lock.newCondition();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
            sufficientFunds.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println(Thread.currentThread().getName() + " waiting to withdraw: " + amount);
                sufficientFunds.await();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}

class CustomerTask implements Runnable {
    private final BankAccount account;
    private final String transactionType;
    private final double amount;

    public CustomerTask(BankAccount account, String transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        if ("deposit".equalsIgnoreCase(transactionType)) {
            account.deposit(amount);
        } else if ("withdraw".equalsIgnoreCase(transactionType)) {
            account.withdraw(amount);
        }
    }
}
public class BankingSystemExecutor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BankAccount account = new BankAccount(100);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create and submit tasks with different priorities simulated by order and naming
        Runnable depositTask = new CustomerTask(account, "deposit", 200);
        Runnable withdrawTask1 = new CustomerTask(account, "withdraw", 150);
        Runnable withdrawTask2 = new CustomerTask(account, "withdraw", 100);

        Thread depositThread = new Thread(depositTask, "HighPriority-Deposit");
        Thread withdrawThread1 = new Thread(withdrawTask1, "Withdraw-1");
        Thread withdrawThread2 = new Thread(withdrawTask2, "Withdraw-2");

        executor.submit(depositThread);
        executor.submit(withdrawThread1);
        executor.submit(withdrawThread2);

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }

}