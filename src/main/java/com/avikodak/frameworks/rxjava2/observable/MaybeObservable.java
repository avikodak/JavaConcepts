package com.avikodak.frameworks.rxjava2.observable;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public class MaybeObservable {

    public static void main(String[] args) {
        // May be is very similar to standard observable but it may or may not emit
        // an item. It call onComplete method in case if there are no items to emit
        Maybe<Integer> maybeObservable = Maybe.just(1000);

        maybeObservable.subscribe(t -> System.out.println(t));
    }
}
