package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class DistinctExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Alpha")
                .distinct() // Takes distinct items
                .subscribe(item -> System.out.println(item));
    }
}
