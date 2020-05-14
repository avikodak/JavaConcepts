package com.avikodak.frameworks.rxjava2.concurrency;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class ObservableParallelizationExample {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .flatMap(i -> Observable.just(i)
                        .subscribeOn(Schedulers.io())
                        .map(ObservableParallelizationExample::intenseCalculation)
                )
                .subscribe(System.out::println);

    }

    private static <T> T intenseCalculation(T value) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(ThreadLocalRandom.current().nextInt(0, 5)));
        return value;
    }
}
