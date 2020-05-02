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
        new Thread(() -> {
            infiniteColdObservable.subscribe(subscribedObject -> {
                System.out.println("Subscriber 1 " + subscribedObject);
            });
        }).start();


        // Second subscriber running in another thread
        new Thread(() -> {
            infiniteColdObservable.subscribe(subscribedObject -> {
                System.out.println("Subscriber 2 " + subscribedObject);
            });
        }).start();
    }
}
