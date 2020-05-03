package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class DefaultIfEmpty {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .filter(item -> item.length() > 10)
                .defaultIfEmpty("No item available with length greater than 10")
                .subscribe(item -> System.out.println(item));
    }
}
