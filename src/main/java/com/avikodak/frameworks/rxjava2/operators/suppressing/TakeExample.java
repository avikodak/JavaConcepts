package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class TakeExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .take(3) // Takes only first three items
                .subscribe(item -> System.out.println(item));
    }
}
