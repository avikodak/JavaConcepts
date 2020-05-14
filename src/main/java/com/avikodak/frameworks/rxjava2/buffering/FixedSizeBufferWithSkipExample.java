package com.avikodak.frameworks.rxjava2.buffering;

import io.reactivex.Observable;

public class FixedSizeBufferWithSkipExample {

    public static void main(String[] args) {
        Observable.range(1, 50)
                .buffer(2, 3)
                .subscribe(System.out::println);
    }
}
