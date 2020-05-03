package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Observable;

public class CallableObservableCreation {

    public static void main(String[] args) {
        // If we want to calculations in a deferred / lazy manner
        Observable<Integer> fromCallable = Observable.fromCallable(() -> 1 / 0);

        // Observer listening to from callable observable
        fromCallable.subscribe(
                value -> System.out.println(value),
                throwable -> System.err.println(throwable)
        );
    }
}
