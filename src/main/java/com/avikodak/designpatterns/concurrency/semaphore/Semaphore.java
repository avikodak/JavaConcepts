package com.avikodak.designpatterns.concurrency.semaphore;

public class Semaphore {

    private final int permits;
    private int availablePermits;

    public Semaphore(int requiredPermits) {
        this.availablePermits = requiredPermits;
        this.permits = requiredPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while(availablePermits == 0) {
            wait();
        }
        availablePermits--;
    }

    public synchronized void release() {
        if(availablePermits < permits) {
            availablePermits++;
            notify();
        }
    }
}
