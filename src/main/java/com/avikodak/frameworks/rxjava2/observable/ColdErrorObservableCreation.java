package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Observable;

public class ColdErrorObservableCreation {

    public static void main(String[] args) {

        //Observable emitting error
        Observable<Integer> errorObservable = Observable.create(emitter -> {
            emitter.onError(new RuntimeException("Some exception"));
        });

        // Subscriber initialized to process error
        errorObservable.subscribe(subscribedObject -> {
            System.out.println("received");
        }, throwable -> {
            System.err.println(throwable);
        });
    }
}
