package com.avikodak.frameworks.rxjava2.operators.action;

import io.reactivex.Observable;

public class DoOnCompleteExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnComplete(()-> System.out.println("Subscription complete !"))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));
    }
}
