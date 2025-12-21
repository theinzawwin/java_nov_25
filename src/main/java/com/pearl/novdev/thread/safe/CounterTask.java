package com.pearl.novdev.thread.safe;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterTask implements Runnable {
    private AtomicInteger counter;

    public CounterTask(AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.incrementAndGet();
        }
    }
}