package com.pearl.novdev.thread;


class MyTask extends Thread {
    private String taskName;

    public MyTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        System.out.println(taskName + " started by: " + Thread.currentThread().getName());
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(taskName + " - step " + i);
                Thread.sleep(500); // pause for 0.5 sec to simulate work
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted.");
        }
        System.out.println(taskName + " finished.");
    }
}

public class ThreadHowItWorks {

    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        MyTask t1 = new MyTask("Download File");
        MyTask t2 = new MyTask("Load Image");

        t1.start(); // Starts a new thread
        t2.start(); // Starts another thread

        System.out.println("Main thread continues running...");

        try {
            t1.join(); // Wait for t1 to finish
            t2.join(); // Wait for t2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All tasks finished. Main thread ends.");
    }

}