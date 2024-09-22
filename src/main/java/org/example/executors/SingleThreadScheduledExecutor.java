package org.example.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutor {

    public void execute() {
        // Create a single-thread scheduled executor
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Schedule a task to run after a 5-second delay
        executor.schedule(() -> {
            System.out.println("Task executed after 5-second delay");
        }, 5, TimeUnit.SECONDS);

        // Shutdown the executor after the task is executed
        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("Executor shutdown");
        }, 6, TimeUnit.SECONDS);
    }
}
