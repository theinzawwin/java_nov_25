package com.pearl.novdev.thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDeadlockAvoidance {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread t1 = new Thread(() -> {
            try {
                if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("Thread 1: locked lock1");
                    Thread.sleep(500);

                    if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                        System.out.println("Thread 1: locked lock2");
                        lock2.unlock();
                    } else {
                        System.out.println("Thread 1: failed to lock lock2, avoiding deadlock");
                    }

                    lock1.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("Thread 2: locked lock2");
                    Thread.sleep(500);

                    if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                        System.out.println("Thread 2: locked lock1");
                        lock1.unlock();
                    } else {
                        System.out.println("Thread 2: failed to lock lock1, avoiding deadlock");
                    }

                    lock2.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

}