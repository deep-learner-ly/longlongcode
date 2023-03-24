package edu.concurrent;

import java.util.concurrent.TimeUnit;

public class ThisMonitor {
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+"method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+"method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  void method3(){
        synchronized (ThisMonitor.class){
            System.out.println(Thread.currentThread().getName()+"method3");
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1,"T1").start();
        new Thread(thisMonitor::method2,"T2").start();
        new Thread(thisMonitor::method3,"T3").start();

    }
}
