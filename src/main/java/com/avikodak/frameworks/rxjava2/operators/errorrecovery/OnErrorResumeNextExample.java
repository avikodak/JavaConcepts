package com.avikodak.frameworks.rxjava2.operators.errorrecovery;

import io.reactivex.Observable;

public class OnErrorResumeNextExample {

    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(t -> 10/t)
                .onErrorResumeNext(Observable.just(-1).repeat(3)) // Switches to this observables whenever an error occurred
                .subscribe(t-> System.out.println(t));

        // Dynamically switch to new observable based on the exception
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(t -> 10/t)
                .onErrorResumeNext((Throwable e) -> Observable.just(-1).repeat(3))
                .subscribe(t-> System.out.println(t));
    }
}
