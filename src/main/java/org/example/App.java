package org.example;

import org.example.executors.CachedThreadPool;
import org.example.executors.FixedThreadPool;
import org.example.executors.ScheduledThreadPool;
import org.example.executors.SingleThreadExecutor;
import org.example.threads.MyRunnable;
import org.example.threads.MyThread;
import org.example.threads.ThreadGroupDemo;
import org.example.threads.ThreadLocalDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        Thread myThread2 = new Thread(new MyRunnable());
//        myThread2.start();
//
//        Runnable runnable = () -> {
//            System.out.println("Run method execution started :: " + Thread.currentThread().getName());
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("Run method execution Ended :: " + Thread.currentThread().getName());
//        };
//
//        Thread thread3 = new Thread(runnable);
//        thread3.start();

//        SingleThreadExecutor executor = new SingleThreadExecutor();

//        FixedThreadPool executor = new FixedThreadPool();

//        CachedThreadPool executor= new CachedThreadPool();

//        ScheduledThreadPool executor = new ScheduledThreadPool();
//
//        executor.execute();

//        ThreadGroupDemo threadGroupDemo = new ThreadGroupDemo();
//        threadGroupDemo.execute();

        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        threadLocalDemo.execute();
    }
}
