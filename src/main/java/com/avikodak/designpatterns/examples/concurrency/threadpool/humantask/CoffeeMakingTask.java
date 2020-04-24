package com.avikodak.designpatterns.examples.concurrency.threadpool.humantask;

public class CoffeeMakingTask extends Task {

    public CoffeeMakingTask() {
        super("Coffee Making Task", 1000L);
    }

    public CoffeeMakingTask(long timeInSeconds) {
        super("Coffee Making Task", timeInSeconds * 1000);
    }
}