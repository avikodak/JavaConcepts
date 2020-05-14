package com.avikodak.frameworks.rxjava2.buffering;

import io.reactivex.Observable;

public class FixedSizeBufferingExample {

    public static void main(String[] args) {
        Observable.range(1, 50)
                .buffer(8)
                .subscribe(System.out::println);
    }

}
