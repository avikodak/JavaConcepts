package com.avikodak.designpatterns.concurrency.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Task {

    private final AtomicInteger idGenerator = new AtomicInteger();

    private final int id;
    private final String name;
    private final long timeInMillis;

    public Task(String name, long timeInMillis) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.timeInMillis = timeInMillis;
    }

    public String getName() {
        return this.name;
    }

    public long taskTimeInMillis() {
        return timeInMillis;
    }
}