package com.avikodak.designpatterns.concurrency.threadpool;

public class PotatoPeelingTask extends Task {

    PotatoPeelingTask() {
        super("Potato Peeling Task", 2000L);
    }

    PotatoPeelingTask(long timeInSeconds) {
        super("Potato Peeling Task", timeInSeconds * 1000);
    }
}