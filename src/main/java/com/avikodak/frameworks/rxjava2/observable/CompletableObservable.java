package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.functions.Action;

public class CompletableObservable {

    public static void main(String[] args){
        // Completable is simply concerned with an action being executed, but it does not receive
        // any emissions.
        Completable completable = Completable.fromAction(() -> System.out.println("Some runnable action"));

    }
}
