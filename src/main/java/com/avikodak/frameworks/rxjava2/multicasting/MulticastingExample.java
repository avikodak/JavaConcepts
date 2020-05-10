package com.avikodak.frameworks.rxjava2.multicasting;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class MulticastingExample {

    public static void main(String[] args) {
        ConnectableObservable<Integer> source = Observable.range(1, 3)
                .map(i -> ThreadLocalRandom.current().nextInt(0, 10000))
                .publish();

        source.subscribe(subscriber("1"));
        source.subscribe(subscriber("2"));
        source.reduce(0, (total, next) -> total += next)
                .subscribe(subscriber("3"));

        source.connect();
    }

    private static Consumer<Integer> subscriber(String name) {
        return (t) -> {
            System.out.println(String.format("Subscriber %s received %s", name, t));
        };
    }
}
