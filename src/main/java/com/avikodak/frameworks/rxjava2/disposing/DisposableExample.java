package com.avikodak.frameworks.rxjava2.disposing;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DisposableExample {

    public static void main(String[] args) {
        Observable<Long> observable =
                Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(t -> System.out.println(t));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

        disposable.dispose();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
    }

}
