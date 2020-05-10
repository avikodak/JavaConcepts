package com.avikodak.frameworks.rxjava2.operators.action;

import io.reactivex.Observable;

public class DoOnNextExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnNext(s -> System.out.println("Processing: " + s))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));
    }
}
