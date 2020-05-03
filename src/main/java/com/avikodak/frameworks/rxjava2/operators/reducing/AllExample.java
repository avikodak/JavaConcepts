package com.avikodak.frameworks.rxjava2.operators.reducing;

import io.reactivex.Observable;

public class AllExample {

    public static void main(String[] args) {
        // All operator is something which verifies that all emissions adhere
        // to predicate
        Observable.just(5, 3, 8 , 1, 4)
                .all(item -> item < 10) // Verifies that all items are less than 10
                .subscribe(truthValue -> System.out.println(truthValue));
    }
}
