package org.example.threads;

public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void execute() {
        threadLocal.set(100);
        System.out.println("Main Thread Value: " + threadLocal.get());

        Thread thread1 = new Thread(() -> {
            threadLocal.set(200);
            System.out.println("Thread 1 Value: " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(300);
            System.out.println("Thread 2 Value: " + threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
