package com.avikodak.frameworks.rxjava2.operators.errorrecovery;

import io.reactivex.Observable;

public class OnErrorReturnExample {

    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorReturnItem(-1)
                .subscribe(t-> System.out.println(t),
                        e-> System.err.println(e));

        // Dynamically return value based on exception
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10/i)
                .onErrorReturn(e -> -1) // Lambda function to dynamically change based on exception
                .subscribe(t-> System.out.println(t));

        // To just go ahead without stopping at the errored emission

        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(t->{
                    try{
                        return 10 / t;
                    } catch(Exception e){
                        return -1;
                    }
                }).subscribe(t -> System.out.println(t));
    }
}
