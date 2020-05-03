package com.avikodak.frameworks.rxjava2.observers;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverImplementation {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        // Implementing observers using anonymous class
        Observer<String> anonymousObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("On subscribed");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Received " + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println(throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };
        observable.subscribe(anonymousObserver);

        observable.subscribe(s -> {
            System.out.println(s);
        }, throwable -> {
            System.err.println(throwable);
        }, () -> {
            System.out.println("Completed");
        }, disposable -> {
            System.out.println("Disposable");
        });
    }
}
