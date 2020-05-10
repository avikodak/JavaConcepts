package com.avikodak.frameworks.rxjava2.multicasting;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RefCountExample {

    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        .refCount();
        //Observer 1
        seconds.take(5)
                .subscribe(subscriber("1"));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        //Observer 2
        seconds.take(2)
                .subscribe(subscriber("2"));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        //there should be no more Observers at this point

        //Observer 3
        seconds.subscribe(subscriber("3"));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    private static Consumer<Long> subscriber(String name) {
        return value -> {
            System.out.println(String.format("Subscriber %s received value %s", name, value));
        };
    }
}
