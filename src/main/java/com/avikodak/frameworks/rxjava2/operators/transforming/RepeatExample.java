package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class RepeatExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .repeat(2) // Repeats the emissions twice
                .subscribe(item -> System.out.println(item));
    }
}
