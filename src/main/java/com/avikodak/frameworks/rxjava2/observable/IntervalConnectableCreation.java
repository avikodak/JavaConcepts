package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IntervalConnectableCreation {

    public static void main(String[] args) {
        ConnectableObservable<Long> connectableObservable = Observable
                .interval(500, TimeUnit.MILLISECONDS)
                .publish();

        connectableObservable.subscribe(subscriber("Subscriber 1 "));

        connectableObservable.connect();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

        connectableObservable.subscribe(subscriber("Subscriber 2 "));

        Uninterruptibles.sleepUninterruptibly(Duration.ofMinutes(5));
    }

    private static Consumer<Long> subscriber(String name) {
        return time->{
            System.out.println(name + " " + time);
        };
    }

}
