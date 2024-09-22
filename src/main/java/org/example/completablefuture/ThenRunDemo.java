package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenRunDemo {

    public void execute() {
        // Create a CompletableFuture that completes with a string
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, world!");

        // Log a message when the future completes using thenRun
        future.thenRun(() -> System.out.println("Future completed"));

        // Wait for the future to complete
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
