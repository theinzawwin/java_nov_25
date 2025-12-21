package com.pearl.novdev.thread.assignment;


class BankAccountNoExecutor {
    private double balance;
    private final java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
    private final java.util.concurrent.locks.Condition sufficientFunds = lock.newCondition();

    public BankAccountNoExecutor(double initialBalance) {
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

class CustomerThreadNoExecutor extends Thread {
    private final BankAccountNoExecutor account;
    private final String transactionType;
    private final double amount;

    public CustomerThreadNoExecutor(BankAccountNoExecutor account, String transactionType, double amount, String name) {
        super(name);
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


public class BankingSystemNoExecutor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BankAccountNoExecutor account = new BankAccountNoExecutor(100);

        CustomerThreadNoExecutor depositThread = new CustomerThreadNoExecutor(account, "deposit", 200, "HighPriority-Deposit");
        CustomerThreadNoExecutor withdrawThread1 = new CustomerThreadNoExecutor(account, "withdraw", 150, "Withdraw-1");
        CustomerThreadNoExecutor withdrawThread2 = new CustomerThreadNoExecutor(account, "withdraw", 100, "Withdraw-2");

        depositThread.setPriority(Thread.MAX_PRIORITY);
        withdrawThread1.setPriority(Thread.NORM_PRIORITY);
        withdrawThread2.setPriority(Thread.NORM_PRIORITY);

        depositThread.start();
        withdrawThread1.start();
        withdrawThread2.start();

        try {
            depositThread.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }

}

