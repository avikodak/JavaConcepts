package com.avikodak.frameworks.rxjava2.operators.reducing;

import io.reactivex.Observable;

public class CountExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .count()
                .subscribe(count -> System.out.println(count));
    }
}
