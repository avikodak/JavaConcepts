package com.avikodak.frameworks.rxjava2.operators.collections;

import io.reactivex.Observable;

public class ToListExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .toList()
                .subscribe(list -> System.out.println(list));
    }
}
