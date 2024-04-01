package org.example;

public class TestThreads {

    public static void main(String[] args) throws InterruptedException {
        final int count = 100_000;
        final Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            final int n = i;
            if (args.length == 0 || !args[0].equals("virtual")) {
                System.out.println("Starting thread #" + i);
                threads[i] = new Thread(() -> sleep(n));
                threads[i].setDaemon(true);
                threads[i].start();
            } else {
                threads[i] = Thread.startVirtualThread(() -> sleep(n));
            }
        }
        for (int i = 0; i < count; i++) {
            threads[i].join();
        }
    }

    public static void sleep(int n) {
        try {
            Thread.sleep(1000);
            System.out.printf("Thread # %s finished\n", n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}