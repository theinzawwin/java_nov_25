package com.pearl.novdev.thread.completablefuture;

import java.util.concurrent.CompletableFuture;

public class BasicCompletableFuture {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running in a separate thread.");
            System.out.println("Completable Running Thread=>"+Thread.currentThread().getName());
        });

        // Wait for it to complete
        future.join();
        System.out.println("Main thread continues...");
        System.out.println("Normal Running Thread=>"+Thread.currentThread().getName());
        //returnValueFromCompletableFuture();

        //thenApplyAndThenAccept();

        //combineTwoFutures();

        exceptionallyTest();
    }
    static void returnValueFromCompletableFuture() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello from async task!";
        });

        // Get the result
        System.out.println(future.join());
    }

    //thenApply And thenAccept
    static void thenApplyAndThenAccept() {
        CompletableFuture.supplyAsync(() -> 10)
                .thenApply(num -> num * 2)     // returns another CompletableFuture
                .thenAccept(result -> System.out.println("Result: " + result));
    }

    // Combine two Futures
    static void combineTwoFutures() {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combined = f1.thenCombine(f2, (a, b) -> a + b);
        System.out.println("Sum: " + combined.join());
    }

    // exceptionally
    static void exceptionallyTest() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong");
            return 10;
        }).exceptionally(ex -> {
            System.out.println("Error: " + ex.getMessage());
            return 0;  // Fallback
        });

        System.out.println("Result: " + future.join());
    }
}