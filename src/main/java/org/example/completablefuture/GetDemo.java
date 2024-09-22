package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class GetDemo {

    public void execute() {
        // Create a CompletableFuture that completes with a string
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, world!");

        // Retrieve the result using get
        try {
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
