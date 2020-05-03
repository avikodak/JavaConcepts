package com.avikodak.frameworks.rxjava2.combiningobservables;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MergeInfiniteObservableExample {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(interval -> interval + 1)
                .map(t -> "Source 1 :" + t + " seconds");

        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(tick -> (tick + 1) *300)
                .map(t->"Source 2 :" + t +" seconds");

        Observable<String> mergedObservable = Observable.merge(source1, source2);
        mergedObservable.subscribe(System.out::println);

        Uninterruptibles.sleepUninterruptibly(Duration.ofMinutes(5));
    }

}
