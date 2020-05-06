package com.avikodak.frameworks.rxjava2.combiningobservables;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class ZipObservableExample {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon");
        Observable<Integer> source2 = Observable.range(1, 6);

        Observable.zip(source1, source2, (s, i) -> s + "-" + i)
                .subscribe(t -> System.out.println(t));

        // Emits at regular intervals of one second
        Observable<String> source3 = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon");
        Observable<Long> source4 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(source3, source4, (s, i) -> s)
                .subscribe(t -> System.out.println("Received emission at " + LocalTime.now()));
        Uninterruptibles.sleepUninterruptibly(Duration.ofMinutes(5));
    }
}
