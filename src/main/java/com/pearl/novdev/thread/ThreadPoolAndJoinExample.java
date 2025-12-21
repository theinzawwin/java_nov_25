package com.pearl.novdev.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CustomThread extends Thread {
    public CustomThread(String name) {
        setName(name); // Set thread name
    }

    @Override
    public void run() {
        System.out.println(getName() + " (Priority: " + getPriority() + ") started.");
        try {
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " finished.");
    }
}

public class ThreadPoolAndJoinExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 🔹 Show main thread info
        Thread mainThread = Thread.currentThread();
        System.out.println("Main thread: " + mainThread.getName());

        // 🔹 Create threads with names and priorities
        CustomThread t1 = new CustomThread("Worker-1");
        CustomThread t2 = new CustomThread("Worker-2");

        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.MIN_PRIORITY); // 1

        t1.start();
        t2.start();

        // 🔹 Use join to wait for them
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while joining.");
        }

        // 🔹 Thread pool using ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable poolTask1 = () -> {
            System.out.println("Task 1 by " + Thread.currentThread().getName());
        };

        Runnable poolTask2 = () -> {
            System.out.println("Task 2 by " + Thread.currentThread().getName());
        };

        executor.submit(poolTask1);
        executor.submit(poolTask2);
        executor.shutdown(); // Shutdown the pool

        System.out.println("Main thread ends.");
    }

}