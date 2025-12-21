package com.pearl.novdev.thread;

class Task extends Thread {
    String taskName;
    public Task(String name) {
        this.taskName = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - Step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
            }
        }
    }
}
public class ParallelExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Task t1 = new Task("Parallel-Task-1");
        Task t2 = new Task("Parallel-Task-2");

        t1.start();
        t2.start();

        System.out.println("Main thread ends (may finish before threads).");
    }

}
