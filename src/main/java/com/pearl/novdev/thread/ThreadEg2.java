package com.pearl.novdev.thread;

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable Thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Runnable thread interrupted");
            }
        }
    }
}

public class ThreadEg2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

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
