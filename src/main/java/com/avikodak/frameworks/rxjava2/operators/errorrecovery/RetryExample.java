package com.avikodak.frameworks.rxjava2.operators.errorrecovery;

import io.reactivex.Observable;

public class RetryExample {

    public static void main(String[] args) {
        // Retries infinite number of times
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(t -> 10 / t)
                .retry()
                .subscribe(t-> System.out.println(t));
    }
}
