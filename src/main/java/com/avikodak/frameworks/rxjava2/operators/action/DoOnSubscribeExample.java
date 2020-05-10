package com.avikodak.frameworks.rxjava2.operators.action;

import io.reactivex.Observable;

public class DoOnSubscribeExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnSubscribe(disposable -> {
                    System.out.println("Subscribed");
                })
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));
    }
}
