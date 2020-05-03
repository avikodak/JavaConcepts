package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ColdFutureObservableCreation {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
            return 1000;
        });

        Observable<Integer> integerObservable = Observable.fromFuture(future);

        integerObservable.subscribe(subscriber("Subscriber 1"));

        integerObservable.subscribe(subscriber("Subscriber 2"));
    }

    private static Consumer<Integer> subscriber(String name) {
        return value -> {
            System.out.println(String.format("%s %s", name, value));
        };
    }
}
