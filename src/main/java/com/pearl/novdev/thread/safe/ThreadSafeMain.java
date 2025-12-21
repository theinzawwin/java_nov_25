package com.pearl.novdev.thread.safe;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeMain {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new CounterTask(counter));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final count: " + counter.get());
    }
}
