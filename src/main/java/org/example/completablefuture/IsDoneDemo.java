package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class IsDoneDemo {

    public void execute() {
        // Create a CompletableFuture that completes with a string
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, world!";
        });

        // Check the status of the future
        while (!future.isDone()) {
            System.out.println("Future is not done yet...");
            try {
                Thread.sleep(500); // Polling delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Retrieve and print the result
        future.thenAccept(result -> System.out.println("Result: " + result));
    }
}
