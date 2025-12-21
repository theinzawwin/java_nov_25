package com.pearl.novdev.thread.assignment.file;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        File folder = new File("files");
        List<Future<Integer>> results = new ArrayList<>();

        for (File file : folder.listFiles()) {
            results.add(executor.submit(new FileTask(file)));
        }

        int total = 0;
        for (Future<Integer> f : results) {
            total += f.get();
        }

        System.out.println("Total words: " + total);
        executor.shutdown();
    }
}