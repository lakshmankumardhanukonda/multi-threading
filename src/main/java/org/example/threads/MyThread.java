package org.example.threads;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Run method execution started :: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Run method execution Ended :: " + Thread.currentThread().getName());
    }

}
