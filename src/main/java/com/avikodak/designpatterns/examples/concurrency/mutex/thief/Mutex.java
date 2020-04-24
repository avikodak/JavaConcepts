package com.avikodak.designpatterns.examples.concurrency.mutex.thief;

public class Mutex {

    private Object owner;

    public Object getOwner() {
        return owner;
    }

    public synchronized void acquire() throws InterruptedException{
        while(owner != null) {
            wait();
        }
        owner = Thread.currentThread();
    }

    public synchronized void release() {
        if(owner == Thread.currentThread()) {
            owner = null;
            notify();
        }
    }
}
