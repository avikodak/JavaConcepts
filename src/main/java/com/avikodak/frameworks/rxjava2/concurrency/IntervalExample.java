package com.avikodak.frameworks.rxjava2.concurrency;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IntervalExample {

    public static void main(String[] args) {
        // Interval runs on the second thread
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(i-> System.out.println(String.format("%s receieved value %s", Thread.currentThread().getName(), i)));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
    }
}
