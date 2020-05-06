package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class ScanExample {

    public static void main(String[] args) {
        // Scan keeps rolling aggregator
        Observable.just(2, 4, 5, 3, 1, 10)
                .scan((runningSum, value) -> runningSum += value)
                .subscribe(value -> System.out.println("Running Sum:" + value));


        Observable.just(2, 4, 5, 3, 1, 10)
                .scan(10, (runningSum, value) -> runningSum += value) // Starts with an initial value of 10
                .subscribe(value -> System.out.println("Running sum:" + value));
    }
}
