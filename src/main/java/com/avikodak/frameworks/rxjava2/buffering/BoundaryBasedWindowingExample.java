package com.avikodak.frameworks.rxjava2.buffering;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BoundaryBasedWindowingExample {

    public static void main(String[] args) {
        Observable<Long> cutoffs = Observable.interval(1, TimeUnit.SECONDS);
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .window(cutoffs)
                .flatMapSingle(obs -> obs.reduce("", (total, next) ->
                        total + (total.equals("") ? "" : "|") + next))
                .subscribe(System.out::println);

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(30));
    }
}
