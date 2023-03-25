package edu.concurrent;

@FunctionalInterface
public interface TreadFactory {
    Thread createThread(Runnable runnable);
}
