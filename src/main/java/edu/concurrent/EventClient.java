package edu.concurrent;

import java.util.concurrent.TimeUnit;

public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(()->{
            for (;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer").start();
        new Thread(()->{
            for (;;){
                EventQueue.Event event = eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();

    }
}
