package org.example.executors;

import org.example.tasks.CallableTask;
import org.example.tasks.RunnableTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPool {

    public void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        RunnableTask task1 = new RunnableTask();
        CallableTask task2 = new CallableTask();
        RunnableTask task3 = new RunnableTask();

        executorService.submit(task1);
        Future<String> result = executorService.submit(task2);
        executorService.submit(task3);

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        System.out.println("main thread execution finished");
    }
}
