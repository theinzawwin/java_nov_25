package com.pearl.novdev.thread.callable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Student s1 = new Student(1, "Aung Aung", Arrays.asList(80, 75, 90));
        Student s2 = new Student(2, "Su Su", Arrays.asList(85, 88, 92));
        Student s3 = new Student(3, "Kyaw Kyaw", Arrays.asList(70, 65, 78));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<Integer>> results = new ArrayList<>();

        results.add(executor.submit(new MarksCalculatorTask(s1)));
        results.add(executor.submit(new MarksCalculatorTask(s2)));
        results.add(executor.submit(new MarksCalculatorTask(s3)));

        System.out.println("\n--- Final Results ---");
        for (Future<Integer> future : results) {
            System.out.println("Total Marks: " + future.get());
        }

        executor.shutdown();
    }
}
