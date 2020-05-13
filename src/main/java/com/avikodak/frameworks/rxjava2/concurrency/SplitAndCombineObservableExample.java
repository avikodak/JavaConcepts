package com.avikodak.frameworks.rxjava2.concurrency;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class SplitAndCombineObservableExample {

    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                        .subscribeOn(Schedulers.computation())
                        .map(s -> intenseCalculation((s)));
        Observable<Integer> source2 =
                Observable.range(1,6)
                        .subscribeOn(Schedulers.computation())
                        .map(s -> intenseCalculation((s)));

        Observable.zip(source1, source2, (s, integer) -> String.format("%s - %s", s, integer))
                .subscribe(t-> System.out.println(t));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(30));
    }

    private static <T> T intenseCalculation(T value) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(ThreadLocalRandom.current().nextInt(0, 3)));
        return value;
    }
}
