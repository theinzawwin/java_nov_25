package com.pearl.novdev.thread.interthread;


class SharedBuffer {
    private int data;
    private boolean hasData = false;

    // Producer puts data in buffer
    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait(); // wait for consumer to consume
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify(); // notify consumer
    }

    // Consumer gets data from buffer
    public synchronized int consume() {
        while (!hasData) {
            try {
                wait(); // wait for producer to produce
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // notify producer
        return data;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(500); // simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(800); // simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumerExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }

}