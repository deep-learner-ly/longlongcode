package edu.concurrent;

import java.util.LinkedList;
/**
 * 两个进程通信，多个进程会报错
 * if ==> while, notify ==>notifyAll
 */

public class EventQueue {
    private final int max;
    static class Event{

    }
    private final LinkedList<Event> eventQueue =  new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;
    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }
    public EventQueue(int max){
        this.max = max;
    }

    public void offer(Event event){
        synchronized (eventQueue){
//          while (eventQueue.size()>=max){
            if (eventQueue.size()>=max){
                try {
                    System.out.println("queue is full");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
            System.out.println("a new event is submitted");
            eventQueue.addLast(event);
            // 叫醒因为队空而阻塞的消费者
            //eventQueue.notifyAll();
            eventQueue.notify();

        }
    }
    public Event take(){
        synchronized (eventQueue){
            if (eventQueue.isEmpty()){
                try {
                    System.out.println("queue is empty");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            // 叫醒因为队满而阻塞的生产者
            this.eventQueue.notify();
            System.out.println(event+ " is handled");
            return event;
        }
    }
}
