package com.avikodak.frameworks.rxjava2.operators.suppressing;

import io.reactivex.Observable;

public class FilterExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .filter(t -> t.length() == 5) // Filters items which have length == 5
                .subscribe(item -> System.out.println(item));

    }
}
