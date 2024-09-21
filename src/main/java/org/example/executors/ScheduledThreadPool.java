package org.example.executors;

import org.example.tasks.CallableTask;
import org.example.tasks.RunnableTask;

import java.util.concurrent.*;

public class ScheduledThreadPool {

    public void execute() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        RunnableTask task1 = new RunnableTask();
        CallableTask task2 = new CallableTask();
        RunnableTask task3 = new RunnableTask();

        executorService.schedule(task1, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(task3, 2, 3, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(task1, 2, 3, TimeUnit.SECONDS);
        Future<String> result = executorService.schedule(task2, 2, TimeUnit.SECONDS);

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
