package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class SkipExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .skip(3) // Skips first three items
                .subscribe(item -> System.out.println(item));
    }
}
