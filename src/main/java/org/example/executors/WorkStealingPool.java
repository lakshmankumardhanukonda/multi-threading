package org.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPool {

    public void execute() {
        // Create a work-stealing pool
        ExecutorService executor = Executors.newWorkStealingPool();

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i + 1;
            executor.submit(() -> {
                System.out.println("Executing task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate task execution
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskNumber + " completed by " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
