package edu.concurrent;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 守护线程拥有自动结束自己生命周期的特性
        thread.setDaemon(true);

        thread.start();
        Thread.sleep(2000L);
        System.out.println("主线程结束");

    }
}
