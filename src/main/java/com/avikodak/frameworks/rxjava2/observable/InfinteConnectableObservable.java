package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class InfinteConnectableObservable {

    public static void main(String[] args) {
        // Creates a infinte cold observable and converts it to a hot observable
        ConnectableObservable<Object> infiniteColdObservable = Observable.create(emitter -> {
            int counter = 0;
            while (true) {
                emitter.onNext(counter++);

                // Sleeping uninterruptibly
                Uninterruptibles.sleepUninterruptibly(
                        Duration.ofSeconds(ThreadLocalRandom.current().nextInt(3)));
            }
        }).publish();

        // One Subscriber running in first thread
        new Thread(getRunnable(infiniteColdObservable, "Subscriber 1 ")).start();

        // Second subscriber running in another thread
        new Thread(getRunnable(infiniteColdObservable, "Subscriber 2 ")).start();

        new Thread(() -> infiniteColdObservable.connect()).start();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));

        // Second subscriber running in another thread
        new Thread(getRunnable(infiniteColdObservable, "Subscriber 3 ")).start();
    }

    private static Runnable getRunnable(ConnectableObservable<Object> infiniteColdObservable, String s) {
        return () -> {
            infiniteColdObservable.subscribe(subscribedObject -> {
                System.out.println(s + subscribedObject);
            });
        };
    }
}
