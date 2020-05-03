package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class SkipWhileExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .skipWhile(item -> item.length() == 5) // Skips while the length of items are equal to 5
                .subscribe(item -> System.out.println(item));
    }
}
