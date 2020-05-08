package com.avikodak.frameworks.rxjava2.combiningobservables;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CombineLatest {

    public static void main(String[] args) {
        Observable<Long> sourceOne = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> sourceTwo = Observable.interval(1, TimeUnit.SECONDS);
        Observable.combineLatest(sourceOne, sourceTwo,
                (l1, l2) -> String.format("From Source 1: %s, From Source 2: %s", l1, l2))
                .subscribe(t -> System.out.println(t));

        Uninterruptibles.sleepUninterruptibly(Duration.ofMinutes(5));
    }
}
