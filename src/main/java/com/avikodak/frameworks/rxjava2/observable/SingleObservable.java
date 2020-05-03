package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class SingleObservable {

    public static void main(String[] args) {
        // This single observable pushes only one item to observer
        Single<Integer> singleObservable = Single.just(1);

        singleObservable.subscribe(subscriber("Subscriber 1"));

        singleObservable.subscribe(subscriber("Subscriber 2"));
    }

    private static Consumer<Integer> subscriber(String name) {
        return i -> {
            System.out.println(String.format("%s %s", name, i));
        };
    }
}
