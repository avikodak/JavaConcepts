package com.avikodak.frameworks.rxjava2.operators.reducing;

import io.reactivex.Observable;

public class ReduceExample {

    public static void main(String[] args) {
        Observable.just(10, 2, 3 , 5, 28, 8)
                .reduce((total, next) -> total + next) // Reduces all the emissions to single value
                .subscribe(total-> System.out.println(total));
    }
}
