package org.example.threads;

public class ThreadGroupDemo {

    public void execute() {
        ThreadGroup group1 = new ThreadGroup("Group 1");
        ThreadGroup parentGroup = new ThreadGroup("Parent Group");
        ThreadGroup group2 = new ThreadGroup(parentGroup, "Group 2");

        Thread thread1 = new Thread(group1, () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " in " + group1.getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 1");

        Thread thread2 = new Thread(group2, () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " in " + group2.getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 2");

        group1.setMaxPriority(Thread.NORM_PRIORITY);
        group2.setMaxPriority(Thread.NORM_PRIORITY);

        thread1.start();
        thread2.start();

        int activeThreadsInGroup1 = group1.activeCount();
        System.out.println("Active Threads: " + activeThreadsInGroup1);

        int activeThreadsInGroup2 = group2.activeCount();
        System.out.println("Active Threads: " + activeThreadsInGroup2);

        int activeGroups = parentGroup.activeGroupCount();
        System.out.println("Active Groups: " + activeGroups);

        Thread[] threads = new Thread[group1.activeCount()];
        group1.enumerate(threads);
        for (Thread t : threads) {
            System.out.println(t.getName());
        }

        Thread[] threads1 = new Thread[group2.activeCount()];
        group2.enumerate(threads1);
        for (Thread t : threads1) {
            System.out.println(t.getName());
        }

        int maxPriority = group1.getMaxPriority();
        System.out.println("Max Priority: " + maxPriority);

        group1.interrupt();
        group2.interrupt();
    }
}
