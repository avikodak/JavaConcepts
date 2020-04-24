package com.avikodak.designpatterns.examples.concurrency.threadpool.humantask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class Worker implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(App.class);
    private Task task;

    public Worker(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        log.info(String.format("Running %s with id %d", task.getName(), task.taskTimeInMillis()));
        try {
            sleep(task.taskTimeInMillis());
        } catch (InterruptedException e) {
            log.warn(String.format("Task %s execution interrupted", task.getName()));
        }
    }
}