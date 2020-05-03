package com.avikodak.frameworks.rxjava2.operators.collections;

import io.reactivex.Observable;

public class ToMapExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .toMap(item -> item.charAt(0))
                .subscribe(map-> System.out.println(map));

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .toMap(item -> item.length())
                .subscribe(map -> System.out.println(map));
    }
}
