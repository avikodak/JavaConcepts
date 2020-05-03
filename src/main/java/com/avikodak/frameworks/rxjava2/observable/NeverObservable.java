package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;

public class NeverObservable {

    public static void main(String[] args){
        // Never calls onComplete thus causing the observers to wait forever
        // for events
        Observable<Integer> neverObservable = Observable.never();

        neverObservable.subscribe(i-> System.out.println("Subcriber 1"));

        neverObservable.subscribe(i -> System.out.println("Subscriber 2"));

        // Need to sleep infinitely because never observable runs in a separate
        // thread
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(100));
    }
}
