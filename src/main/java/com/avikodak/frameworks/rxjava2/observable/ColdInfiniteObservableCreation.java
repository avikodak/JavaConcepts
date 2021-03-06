package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class ColdInfiniteObservableCreation {

    public static void main(String[] args) {

        // Creates a infinte cold observable
        Observable<Integer> infiniteColdObservable = Observable.create(emitter -> {
            int counter = 0;
            while (true) {
                emitter.onNext(counter++);

                // Sleeping uninterruptibly
                Uninterruptibles.sleepUninterruptibly(
                        Duration.ofSeconds(ThreadLocalRandom.current().nextInt(4)));
            }
        });

        // One Subscriber running in first thread
        new Thread(getRunnable(infiniteColdObservable, "Subscriber 1 ")).start();


        // Second subscriber running in another thread
        new Thread(getRunnable(infiniteColdObservable, "Subscriber 2 ")).start();
    }

    private static Runnable getRunnable(Observable<Integer> infiniteColdObservable, String s) {
        return () -> {
            infiniteColdObservable.subscribe(subscribedObject -> {
                System.out.println(s + subscribedObject);
            });
        };
    }
}
