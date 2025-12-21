package com.pearl.novdev.thread;


import java.util.concurrent.locks.ReentrantLock;

class SharedCounter {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void increment() {

        lock.lock(); // Acquire the lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
        } finally {
            lock.unlock(); // Always release the lock in finally block
        }

    }

    public int getCount() {
        return count;
    }
}
public class ReentrantLockExample {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        SharedCounter counter = new SharedCounter();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count = " + counter.getCount());
    }

}