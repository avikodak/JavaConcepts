package com.avikodak.frameworks.rxjava2.combiningobservables;

import io.reactivex.Observable;

public class ConcatObservableExample {

    public static void main(String[] args) {
        Observable<Integer> source1 = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> source2 = Observable.just(6, 7, 8, 9 , 10);
        Observable.concat(source1, source2)
                .subscribe(System.out::println);


        // Concat with observable
        Observable.just(1, 2, 3, 4, 5)
                .concatWith(Observable.just(6, 7, 8, 9 , 10))
                .subscribe(System.out::println);
    }
}
