package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Observable;

public class RangeObservableCreation {

    public static void main(String[] args) {
        // Range observable basically starts from given start arguments and increments by one
        Observable.range(10, 10).subscribe(t -> {
            System.out.println(t);
        });

    }
}
