package com.avikodak.frameworks.rxjava2.observable;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ColdFiniteObservableCreation {

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
        finiteColdObservable.subscribe(subscriber("Subscriber 3"));

        // Subscriber two will also listen to all events
        finiteColdObservable.subscribe(subscriber("Subscriber 2"));


        //#####################################################################################//
        // Observable using Just Method
        //#####################################################################################//

        Observable<String> finiteObservable2 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Consumer<String> subscriber = subscriberObject -> {
            System.out.println("Subscriber  " + subscriberObject);
        };
        finiteObservable2.subscribe(subscriber("Subscriber 1"));

        //#####################################################################################//
        // Observable using iterables
        //#####################################################################################//

        List<String> inputList = List.of("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<String> finiteObservable3 = Observable.fromIterable(inputList);

        finiteObservable3.subscribe(subscriber("Subscriber 1"));
    }

    private static Consumer<String> subscriber(String name) {
        return subscriberObject -> {
            System.out.println(String.format("%s received %s", name, subscriberObject));
        };
    }
}
