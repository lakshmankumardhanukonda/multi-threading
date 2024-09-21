package org.example.executors;

import org.example.tasks.CallableTask;
import org.example.tasks.RunnableTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutor {


    public void execute() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        RunnableTask task1 = new RunnableTask();

        CallableTask task2 = new CallableTask();

        Future<String> result = executorService.submit(task2);

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.submit(task1);


        executorService.shutdown();
    }

}
