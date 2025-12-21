package com.pearl.novdev.thread;

class DeadLockSharedResource {
    final Object lock1 = new Object();
    final Object lock2 = new Object();
}
public class DeadlockSolution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeadLockSharedResource resource = new DeadLockSharedResource();

        Thread t1 = new Thread(() -> {
            synchronized (resource.lock1) {
                System.out.println("Thread 1: locked lock1");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource.lock2) {
                    System.out.println("Thread 1: locked lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource.lock1) { // 🔄 SAME LOCK ORDER!
                System.out.println("Thread 2: locked lock1");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource.lock2) {
                    System.out.println("Thread 2: locked lock2");
                }
            }
        });

        t1.start();
        t2.start();
    }

}

