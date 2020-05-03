package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Observable;

public class EmptyObservable {

    public static void main(String[] args) {
        // Empty observable represents null in rx java
        Observable<Integer> emptyObservable = Observable.empty();

        emptyObservable.subscribe(i -> System.out.println(i));
    }
}
