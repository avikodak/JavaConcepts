package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ColdIntervalObservableCreation {

    public static void main(String[] args) {
        Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);

        intervalObservable.subscribe(subscriber("Subscriber 1"));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

        intervalObservable.subscribe(subscriber("Subscriber 2"));

        // Interval operates on a timer and it needs to run on a
        // separate thread and will be run on the computation Scheduler
        // by default.
        Uninterruptibles.sleepUninterruptibly(Duration.ofMinutes(5));
    }

    private static Consumer<Long> subscriber(String name) {
        return time -> {
            System.out.println(String.format("%s %s", name , time));
        };
    }
}
