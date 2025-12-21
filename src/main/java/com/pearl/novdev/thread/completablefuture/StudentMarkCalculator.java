package com.pearl.novdev.thread.completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class StudentMarkCalculator {

    public static CompletableFuture<Integer> getMathMarks() {
        return CompletableFuture.supplyAsync(() -> {
            delay(1);
            return 85;
        });
    }

    public static CompletableFuture<Integer> getScienceMarks() {
        return CompletableFuture.supplyAsync(() -> {
            delay(2);
            return 90;
        });
    }

    public static CompletableFuture<Integer> getEnglishMarks() {
        return CompletableFuture.supplyAsync(() -> {
            delay(1);
            return 88;
        });
    }

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);  // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CompletableFuture<Integer> mathFuture = getMathMarks();
        CompletableFuture<Integer> scienceFuture = getScienceMarks();
        CompletableFuture<Integer> englishFuture = getEnglishMarks();

        // Combine all marks and calculate total + average
        CompletableFuture<Void> result = mathFuture
                .thenCombine(scienceFuture, Integer::sum)
                .thenCombine(englishFuture, Integer::sum)
                .thenAccept(total -> {
                    double average = total / 3.0;
                    System.out.println("Total Marks: " + total);
                    System.out.println("Average Marks: " + average);
                });

        // Wait for all async operations to finish
        result.join();
    }

}

