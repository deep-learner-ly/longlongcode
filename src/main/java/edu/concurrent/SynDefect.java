package edu.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author: LongyunBian
 * @date: 2023/3/24 17:36
 * @Description: 演示syn 阻塞不能被打断
 */
public class SynDefect {
    public synchronized void syncMethod(){
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynDefect synDefect = new SynDefect();
        Thread t1 = new Thread(synDefect::syncMethod, "T1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(synDefect::syncMethod, "T2");
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}
