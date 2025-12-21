package com.pearl.novdev.thread;

class SharedResource {
    final Object lock1 = new Object();
    final Object lock2 = new Object();
}
public class DeadlockExample {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Thread 1 tries to lock lock1 then lock2
        Thread t1 = new Thread(() -> {
            synchronized (resource.lock1) {
                System.out.println("Thread 1: locked lock1");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource.lock2) {
                    System.out.println("Thread 1: locked lock2");
                }
            }
        });

        // Thread 2 tries to lock lock2 then lock1 (opposite order!)
        Thread t2 = new Thread(() -> {
            synchronized (resource.lock2) {
                System.out.println("Thread 2: locked lock2");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource.lock1) {
                    System.out.println("Thread 2: locked lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
