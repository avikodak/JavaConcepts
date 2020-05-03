package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class TakeWhileExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .takeWhile(item -> item.length() < 7) // takes while the condition is true
                .subscribe(item -> System.out.println(item));
    }
}
