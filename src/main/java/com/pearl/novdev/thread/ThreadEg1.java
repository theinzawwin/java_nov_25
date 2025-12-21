package com.pearl.novdev.thread;


class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(500); // Pause for 500ms
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }

        }
    }
}

public class ThreadEg1 {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Start the thread

        // Main thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }

        }
    }

}
