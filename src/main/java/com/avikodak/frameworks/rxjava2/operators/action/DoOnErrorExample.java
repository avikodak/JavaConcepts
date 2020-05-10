package com.avikodak.frameworks.rxjava2.operators.action;

import io.reactivex.Observable;

public class DoOnErrorExample {

    public static void main(String[] args) {
        Observable.just(5, 9, 10 , 0 , 2)
                .map(t -> 10/ t)
                .doOnError(throwable -> System.err.println(throwable))
                .subscribe(
                        i -> System.out.println("Received: " + i),
                        throwable -> System.err.println(throwable));
    }
}
