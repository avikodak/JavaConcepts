package com.avikodak.frameworks.rxjava2.replaying;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import org.checkerframework.checker.units.qual.UnitsBottom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReplayExample {

    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .replay(1)
                .autoConnect();

        observable.subscribe(subscriber("1"));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

        observable.subscribe(subscriber("2"));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(20));
    }

    private static Consumer<Long> subscriber(String name) {
        return l -> {
            System.out.println(String.format("Subscriber %s received %s", name, l));
        };
    }
}
