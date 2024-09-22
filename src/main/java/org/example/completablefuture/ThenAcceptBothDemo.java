package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenAcceptBothDemo {

    public void execute() {
        // Create two CompletableFuture instances
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        // Print the results of both futures using thenAcceptBoth
        future1.thenAcceptBoth(future2, (result1, result2) -> System.out.println(result1 + " " + result2));

        // Wait for the futures to complete
        try {
            future1.get();
            future2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
