package com.avikodak.frameworks.rxjava2.multicasting;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class AutoConnectExample {

    public static void main(String[] args) {
        Observable<Integer> hotObservable = Observable.range(1, 3)
                .publish()
                .autoConnect(2); // Waits for two subscriber before it starts firing items

        hotObservable.subscribe(subscriber("1"));
        hotObservable.subscribe(subscriber("2"));
    }

    private static Consumer<Integer> subscriber(String name) {
        return value -> {
            System.out.println(String.format("Subscriber %s received %s", name, value));
        };
    }
}
