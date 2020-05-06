package com.avikodak.frameworks.rxjava2.operators.errorrecovery;

import io.reactivex.Observable;

public class LimitedRetryExample {

    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(t -> 10 / t)
                .retry(2)
                .subscribe(t -> System.out.println(t),
                        e -> System.err.println(e));
    }
}
