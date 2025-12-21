package com.pearl.novdev.thread.callable;

import java.util.concurrent.Callable;

public class MarksCalculatorTask implements Callable<Integer> {

    private Student student;

    public MarksCalculatorTask(Student student) {
        this.student = student;
    }

    @Override
    public Integer call() throws Exception {
        int total = 0;

        for (int mark : student.getMarks()) {
            total += mark;
            Thread.sleep(300); // simulate processing time
        }

        System.out.println(
                Thread.currentThread().getName() +
                        " calculated total for " + student.getName()
        );

        return total;
    }
}
