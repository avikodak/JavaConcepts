package com.avikodak.frameworks.rxjava2.operators.transforming;

import io.reactivex.Observable;

public class StartWithExample {

    public static void main(String[] args) {
        Observable.just("Coffee", "Tea", "Espresso", "Latte")
                .startWith("Coffee Shop Menu") // Appends to the items
                .subscribe(item-> System.out.println(item));
    }
}
