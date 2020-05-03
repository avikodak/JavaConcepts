package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class SwitchIfEmpty {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .filter(t -> t.length() >10)
                .switchIfEmpty(Observable.just("None", "were", "available"))
                .subscribe(item -> System.out.println(item));
    }
}
