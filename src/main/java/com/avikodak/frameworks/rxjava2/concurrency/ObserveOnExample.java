package com.avikodak.frameworks.rxjava2.concurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObserveOnExample {

    public static void main(String[] args) {
        Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO","232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .observeOn(Schedulers.computation())
                .filter(t -> t.matches("[0-9]+"))
                .map(Integer::valueOf)
                .subscribe(value -> System.out.println(value));
    }
}
