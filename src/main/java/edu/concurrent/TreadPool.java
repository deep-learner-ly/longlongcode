package edu.concurrent;

public interface TreadPool {
    void execute(Runnable runnable);
    int getInitSize();
    int getMaxSize();
    int getCoreSize();
    int getQueueSize();
    int getActiveCount();
    boolean isShutdown();
}
