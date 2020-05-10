package com.avikodak.frameworks.rxjava2.disposing;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CompositeDisposableExample {

    private static final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable1 = seconds.subscribe(subscriber("Subscriber 1"));

        Disposable disposable2 = seconds.subscribe(subscriber("Subscriber 2"));

        compositeDisposable.add(disposable1);
        compositeDisposable.add(disposable2);

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

        compositeDisposable.dispose();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }

    private static Consumer<Long> subscriber(String name) {
        return t -> {
            System.out.println(String.format("%s received %s", name, t));
        };
    }
}
