package org.example.tasks;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

    public String call() {

        System.out.println("Call method execution started :: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Call method execution ended :: " + Thread.currentThread().getName());

        return "Dummy Result";
    }
}
