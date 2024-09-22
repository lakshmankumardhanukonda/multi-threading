package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompleteDemo {

    public void execute() {
        // Create a CompletableFuture
        CompletableFuture<String> future = new CompletableFuture<>();

        // Simulate an external source providing a result
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete("Result from external source");
        }).start();

        // Process the result when available
        future.thenAccept(result -> System.out.println("Received result: " + result));

        // Wait for the future to complete
        future.join();
    }
}
