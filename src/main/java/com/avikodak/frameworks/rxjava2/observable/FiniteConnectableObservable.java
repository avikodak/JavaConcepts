package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

public class FiniteConnectableObservable {

    public static void main(String[] args) {
        // Converts a cold observable to hot observable
        ConnectableObservable<String> coldToHotObservable = Observable
                .just("Alpha", "Beta", "Gamma", "Epsilon")
                .publish();

        coldToHotObservable.subscribe(subscriber("Subscriber 1"));

        coldToHotObservable.subscribe(subscriber("Subscriber 2"));

        coldToHotObservable.connect();

        // This subscriber won't receive any events because it was connected after all events were fired
        coldToHotObservable.subscribe(subscriber("Subscriber 3"));
    }

    private static Consumer<String> subscriber(String name) {
        return subscriberObject -> {
            System.out.println(String.format("%s received %s", name, subscriberObject));
        };
    }
}
