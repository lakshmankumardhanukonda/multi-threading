package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompleteExpectionallyDemo {

    public void execute() {
        // Create a CompletableFuture
        CompletableFuture<String> future = new CompletableFuture<>();

        // Simulate an asynchronous task that encounters an exception
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate delay
                throw new RuntimeException("Error occurred during task execution");
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();

        // Handle the result or exception
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception: " + ex.getMessage());
            } else {
                System.out.println("Result: " + result);
            }
        });

        // Wait for the future to complete
        future.join();
    }
}
