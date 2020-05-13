package com.avikodak.frameworks.rxjava2.concurrency;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;

public class SchedulerNewThreadExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.newThread())
                .subscribe(t -> System.out.println(t));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}
