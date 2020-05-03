package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


public class DeferObservable {

    private static int start = 1;
    private static int count = 100;

    public static void main(String[] args) {
        // Defer observable is a powerful factory due to its ability to create a separate state for
        //each Observer. When using certain Observable factories, you may run into some nuances
        //if your source is stateful and you want to create a separate state for each Observer.
        Observable<Integer> deferObservable = Observable.defer(() -> Observable.range(1, count));

        // For this observer the range observable start and count will be 1 and 100
        // i.e it is similar to subscribing to Observable.range(1,100);
        deferObservable.subscribe(subscriber("Subscriber 1"));

        // modify count
        start = 100;
        count = 15;

        // For this observer the range observable start and count will be 100 and 15
        // i.e it is similar to subscribing to Observable.range(100,15)
        deferObservable.subscribe(subscriber("Subscriber 2"));
    }

    private static Consumer<Integer> subscriber(String name) {
        return i -> {
            System.out.println(String.format("%s %s", name, i));
        };
    }
}
