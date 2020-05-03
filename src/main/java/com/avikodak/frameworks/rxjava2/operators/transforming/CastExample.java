package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class CastExample {

    public static void main(String[] args) {
        Observable.just("Coffee", "Tea", "Espresso", "Latte")
                .cast(Object.class) // Cast String to Objects
                .subscribe(item -> System.out.println(item));

        // Same functionality
        Observable.just("Alpha", "Beta", "Gamma").map(s -> (Object) s)
                .subscribe(item -> System.out.println(item));
    }
}
