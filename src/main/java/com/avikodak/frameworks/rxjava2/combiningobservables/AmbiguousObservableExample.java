package com.avikodak.frameworks.rxjava2.combiningobservables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class AmbiguousObservableExample {

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(t -> t+1);

    }
}
