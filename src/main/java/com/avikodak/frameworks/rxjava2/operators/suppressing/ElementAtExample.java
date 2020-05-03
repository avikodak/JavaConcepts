package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class ElementAtExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .elementAt(4) // Takes element present in index
                .subscribe(item -> System.out.println(item));
    }
}
