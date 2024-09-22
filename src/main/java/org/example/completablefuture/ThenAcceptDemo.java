package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenAcceptDemo {

    public void execute() {
        // Create a CompletableFuture that completes with a string
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, world!");

        // Log the result using thenAccept
        future.thenAccept(result -> System.out.println("Received result: " + result));

        // Wait for the future to complete
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
