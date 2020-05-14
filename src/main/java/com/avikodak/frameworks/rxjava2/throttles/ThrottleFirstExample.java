package com.avikodak.frameworks.rxjava2.throttles;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ThrottleFirstExample {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 100) // map to elapsed time
                .map(i -> "SOURCE 1: " + i)
                .take(10); // Stops after 10 emissions

        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .map(i -> "SOURCE 2: " + i)
                .take(3); // Stops after 3 emissions

        Observable<String> source3 = Observable.interval(2000, TimeUnit.MILLISECONDS)
                .map(i -> (i +1)*2000)
                .map(i -> "SOURCE 3: "+ i)
                .take(2); // Stops after 2 emissions

        Observable.concat(source1, source2, source3)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(100));
    }
}
