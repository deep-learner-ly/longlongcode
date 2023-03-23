package edu.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread= new Thread(()->{
                try {
                    TimeUnit.MINUTES.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("被中断");
                }
            }
        );
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();


        Thread thread1 = new Thread(()->{
           while (true){

           }
        }
        );
        thread1.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Thread1 is interrupt? %s\n",thread1.isInterrupted());
        thread1.interrupt();
        System.out.printf("Thread1 is interrupt? %s\n",thread1.isInterrupted());
    }
}
