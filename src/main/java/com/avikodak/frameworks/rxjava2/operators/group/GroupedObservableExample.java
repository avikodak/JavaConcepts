package com.avikodak.frameworks.rxjava2.operators.group;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class GroupedObservableExample {

    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable<GroupedObservable<Integer, String>> groupedObservable = source.groupBy(String::length);

        groupedObservable.flatMapSingle(grp -> grp.toList())
                .subscribe(System.out::println);
    }
}
