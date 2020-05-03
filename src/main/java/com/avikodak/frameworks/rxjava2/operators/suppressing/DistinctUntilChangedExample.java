package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class DistinctUntilChangedExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Alpha")
                .distinctUntilChanged() // Omits consecutive same items
                .subscribe(item -> System.out.println(item));
    }
}
