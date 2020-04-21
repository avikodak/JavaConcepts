package com.avikodak.designpatterns.concurrency.threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        log.info("Program Starting");
        List<Task> tasks = List.of(
                new PotatoPeelingTask(3),
                new PotatoPeelingTask(6),
                new CoffeeMakingTask(2),
                new CoffeeMakingTask(6),
                new PotatoPeelingTask(4),
                new CoffeeMakingTask(2),
                new PotatoPeelingTask(4),
                new CoffeeMakingTask(9),
                new PotatoPeelingTask(3),
                new CoffeeMakingTask(2),
                new PotatoPeelingTask(4),
                new CoffeeMakingTask(2),
                new CoffeeMakingTask(7),
                new PotatoPeelingTask(4),
                new PotatoPeelingTask(5)
        );

        // Mapping each task to worker and submitting to executor
        tasks.stream().map(Worker::new).forEach(executor::execute);

        // All tasks were executed, now shutdown
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }
        log.info("Program finished");
    }
}
