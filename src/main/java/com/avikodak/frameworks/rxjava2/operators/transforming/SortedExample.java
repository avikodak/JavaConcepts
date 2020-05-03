package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class SortedExample {

    public static void main(String[] args) {
        Observable.just(1, 5, 3, 2, 0, 9)
                .sorted() // Sorts the items
                .subscribe(item -> System.out.println(item));
    }
}
