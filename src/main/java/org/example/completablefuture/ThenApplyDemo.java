package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApplyDemo {

    public void execute() {
        // Create a CompletableFuture that completes with a string
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");

        // Transform the result to uppercase using thenApply
        CompletableFuture<String> transformedFuture = future.thenApply(String::toUpperCase);

        // Process the transformed result
        transformedFuture.thenAccept(result -> System.out.println("Transformed result: " + result));

        // Wait for the future to complete
        try {
            transformedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
