package com.pearl.novdev.thread;


class PrintDemo2 {
    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter   ---   "  + i );
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class ThreadDemo2 extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo2  PD;

    ThreadDemo2( String name,  PrintDemo2 pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        synchronized(PD) {
            PD.printCount();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
public class WithSynchronizedPrintTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrintDemo2 PD = new PrintDemo2();

        ThreadDemo2 T1 = new ThreadDemo2( "Thread - 1 ", PD );
        ThreadDemo2 T2 = new ThreadDemo2( "Thread - 2 ", PD );

        T1.start();
        T2.start();

        // wait for threads to end
        try {
            T1.join();
            T2.join();
        } catch ( Exception e) {
            System.out.println("Interrupted");
        }
    }

}