package com.avikodak.frameworks.rxjava2.concurrency;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;

public class MultipleObserversSubscribeOnExample {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation());

        source.subscribe(subscriber("1"));
        source.subscribe(subscriber("2"));
        source.subscribe(subscriber("3"));
        source.subscribe(subscriber("4"));
        source.subscribe(subscriber("5"));
        source.subscribe(subscriber("6"));


        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
    }

    private static Consumer<String> subscriber(String index) {
        return value -> {
            System.out.println(
                    String.format("Subscriber %s received value %s on thread %s", index, value,
                            Thread.currentThread().getName()));
        };
    }
}
