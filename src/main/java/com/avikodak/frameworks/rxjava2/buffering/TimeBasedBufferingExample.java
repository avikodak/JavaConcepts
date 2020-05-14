package com.avikodak.frameworks.rxjava2.buffering;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TimeBasedBufferingExample {

    public static void main(String[] args) {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(100));
    }
}
