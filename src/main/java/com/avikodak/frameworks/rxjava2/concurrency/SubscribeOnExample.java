package com.avikodak.frameworks.rxjava2.concurrency;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class SubscribeOnExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(s -> intenseCalculation(s))
                .subscribe(subscriber("1"));

        Observable.range(0, 5)
                .subscribeOn(Schedulers.computation())
                .map(s-> intenseCalculation(s))
                .subscribe(subscriber("2"));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(30));
    }

    private static <T> T intenseCalculation(T value) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(ThreadLocalRandom.current().nextInt(0, 3)));
        return value;
    }

    private static <T> Consumer<T> subscriber(String index) {
        return value-> {
            System.out.println(String.format("Subscriber %s received value %s", index, value));
        };
    }
}
