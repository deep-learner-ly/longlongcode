package edu.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(()->{
            long startTime = System.currentTimeMillis();
//            sleep(2_000L);
            sleep(0,0,2);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Spend %d ms",(endTime-startTime)));
        }).start();

        long startTime = System.currentTimeMillis();
//        sleep(2_000L);
        sleep(0,0,2);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main Spend %d ms",(endTime-startTime)));

    }

    private static void sleep(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void sleep(int h,int m,int s){
        try {
            TimeUnit.HOURS.sleep(h);
            TimeUnit.MINUTES.sleep(m);
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
