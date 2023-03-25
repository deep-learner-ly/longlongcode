package edu.concurrent;

public interface RunnableQueue {
    void offer(Runnable runnable);
    Runnable take();
    int size();
}
