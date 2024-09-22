package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncDemo {
    public void execute() {
        // Simulate fetching data from a remote API
        CompletableFuture<String> dataFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate delay
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Fetched data from API";
        });

        // Process the fetched data
        dataFuture.thenAccept(data -> System.out.println("Data: " + data));

        // Wait for the task to complete
        try {
            dataFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
