package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo {

    public void execute() {
        // Log a message asynchronously
        CompletableFuture<Void> logFuture = CompletableFuture.runAsync(() -> {
            // Simulate delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Logged message: Task completed successfully");
        });

        // Wait for the logging to complete
        logFuture.join();
    }
}
