package com.avikodak.frameworks.rxjava2.operators.transforming;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DelayExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .delay(3, TimeUnit.SECONDS) // Will postpone the emissions for 3 seconds
                .subscribe(item -> System.out.println(item));

        // Delay runs in separate thread hence we need to wait the main thread
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
    }
}
