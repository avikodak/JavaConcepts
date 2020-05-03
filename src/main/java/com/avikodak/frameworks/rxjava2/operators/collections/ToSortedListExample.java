package com.avikodak.frameworks.rxjava2.operators.collections;

import io.reactivex.Observable;

public class ToSortedListExample {

    public static void main(String[] args) {
        Observable.just(2, 3, 1, 7, 6, 5)
                .toSortedList()
                .subscribe(value-> System.out.println(value));
    }
}
