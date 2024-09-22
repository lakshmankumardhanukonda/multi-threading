package org.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactoryDemo {

    public void execute() {
        // Create a custom ThreadFactory
        ThreadFactory customThreadFactory = new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            private final ThreadFactory defaultFactory = Executors.defaultThreadFactory();

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = defaultFactory.newThread(r);
                thread.setName("CustomThread-" + threadNumber.getAndIncrement());
                return thread;
            }
        };

        // Create an ExecutorService with the custom ThreadFactory
        ExecutorService executor = Executors.newFixedThreadPool(2, customThreadFactory);

        // Submit tasks to the executor
        executor.submit(() -> System.out.println("Task 1 executed by: " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("Task 2 executed by: " + Thread.currentThread().getName()));

        // Shutdown the executor
        executor.shutdown();
    }
}
