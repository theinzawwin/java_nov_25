package com.pearl.novdev.thread;


class SafeCounter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}
public class SynchronizedThread {

    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count (With sync): " + counter.count); // Always 2000
    }

}
