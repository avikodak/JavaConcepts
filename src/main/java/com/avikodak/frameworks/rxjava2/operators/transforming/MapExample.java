package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class MapExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .map(item -> item.length()) // Transforms strings to integer
                .distinct() // gets only distinct lengths
                .subscribe(item -> System.out.println(item));
    }
}
