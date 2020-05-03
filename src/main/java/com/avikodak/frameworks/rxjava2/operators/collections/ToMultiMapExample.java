package com.avikodak.frameworks.rxjava2.operators.collections;

import io.reactivex.Observable;

public class ToMultiMapExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .toMultimap(item -> item.length())
                .subscribe(map -> System.out.println(map));
    }
}
