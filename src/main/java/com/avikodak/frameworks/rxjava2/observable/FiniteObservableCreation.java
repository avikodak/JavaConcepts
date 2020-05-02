package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class ObservableCreate {

    public static void main(String[] args) {

        // This creates a cold observables i.e objects are pushed to
        // all subscribers from the beginning. Analogy: It is a CD where
        // each person who has access to CD can play the song at his own
        // leisure
        Observable<String> finiteColdObservable = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onNext("Delta");
            emitter.onNext("Epsilon");
            emitter.onComplete();
        });

        // Subscriber one will listen to all events
        finiteColdObservable.subscribe(subscribedObject -> {
            System.out.println("Subscriber 1 " + subscribedObject);
        });

        // Subscriber two will also listen to all events
        finiteColdObservable.subscribe(subscribedObject -> {
            System.out.println("Subscriber 2 " + subscribedObject);
        });

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

        //Observable emitting error
        Observable<Integer> errorObservable = Observable.create(emitter -> {
            emitter.onError(new RuntimeException("Some exception"));
        });

        // Subscriber initialized to process error
        errorObservable.subscribe(subscribedObject -> {
            System.out.println("received");
        }, throwable -> {
            System.err.println(throwable);
        });
    }
}
