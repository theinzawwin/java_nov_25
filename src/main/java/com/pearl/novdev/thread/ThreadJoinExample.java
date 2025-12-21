package com.pearl.novdev.thread;


class MyTaskJoin extends Thread {
    private String taskName;

    public MyTaskJoin(String name) {
        this.taskName = name;
    }

    public void run() {
        System.out.println(taskName + " started.");
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(taskName + " running step " + i);
                Thread.sleep(500); // simulate work
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted.");
        }
        System.out.println(taskName + " finished.");
    }
}

public class ThreadJoinExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Main thread started.");

        MyTaskJoin t1 = new MyTaskJoin("Task-1");
        MyTaskJoin t2 = new MyTaskJoin("Task-2");

        t1.start();
        try {
            t1.join(); // Main thread waits until t1 finishes
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Task-1.");
        }

        t2.start();
        try {
            t2.join(); // Main thread waits until t2 finishes
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Task-2.");
        }


        System.out.println("Main thread ends after both tasks are complete.");
    }

}
