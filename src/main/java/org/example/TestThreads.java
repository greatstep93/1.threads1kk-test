package org.example;

public class TestThreads {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100_000; i++) {
            if (args.length == 0 || !args[0].equals("virtual")) {
                new Thread(TestThreads::sleep).start();
            } else {
                Thread.startVirtualThread(TestThreads::sleep);
            }

        }
        Thread.sleep(3000);
    }

    public static void sleep() {
        try {
            System.out.println(Thread.currentThread());
            Thread.sleep(100_000_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}