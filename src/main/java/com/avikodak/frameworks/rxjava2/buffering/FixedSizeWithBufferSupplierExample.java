package com.avikodak.frameworks.rxjava2.buffering;

import io.reactivex.Observable;

import java.util.HashSet;

public class FixedSizeWithBufferSupplierExample {

    public static void main(String[] args) {
        Observable.range(1, 50)
                .buffer(8, HashSet::new)
                .subscribe(System.out::println);
    }
}
