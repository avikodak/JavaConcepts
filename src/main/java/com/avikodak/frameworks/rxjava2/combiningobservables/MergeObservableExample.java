package com.avikodak.frameworks.rxjava2.combiningobservables;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.List;

public class MergeObservableExample {

    public static void main(String[] args) {
        //NOTE: Merging observables will not guarantee ordering of emissions
        // in order to have the emissions in order use concat

        // Observable merge
        Observable<String> sourceOne = Observable.just("Alpha", "Beta", "Gamma");
        Observable<String> sourceTwo = Observable.just("Delta", "Epsilon", "Zeta");
        Observable<String> mergedObservable = Observable.merge(sourceOne, sourceTwo);
        sourceOne.subscribe(subscriber("Source one subscriber"));
        sourceTwo.subscribe(subscriber("Source two subscriber"));
        mergedObservable.subscribe(subscriber("Merged source subscriber"));


        // Merge with
        Observable.just("Alpha", "Beta", "Gamma")
                .mergeWith(Observable.just("Delta", "Epsilon", "Zeta"))
                .subscribe(subscriber("Merge with source Subscriber"));

        // Merge Array

        Observable<String> source1 = Observable.just("Alpha", "Beta");
        Observable<String> source2 = Observable.just("Gamma", "Delta");
        Observable<String> source3 = Observable.just("Epsilon", "Zeta");
        Observable<String> source4 = Observable.just("Eta", "Theta");
        Observable<String> source5 =  Observable.just("Iota", "Kappa");
        Observable.mergeArray(source1, source2, source3, source4, source5)
                .subscribe(subscriber("Merge array subscriber"));

        //Merge with list
        Observable<String> listSource1 = Observable.just("Alpha", "Beta");
        Observable<String> listSource2 = Observable.just("Gamma", "Delta");
        Observable<String> listSource3 = Observable.just("Epsilon", "Zeta");
        Observable<String> listSource4 = Observable.just("Eta", "Theta");
        Observable<String> listSource5 =  Observable.just("Iota", "Kappa");
        List<Observable<String>> observableList = ImmutableList.of(listSource1, listSource2,
                listSource3, listSource4, listSource5);
        Observable.merge(observableList)
                .subscribe(subscriber("List merge subscriber"));
    }

    private static Consumer subscriber(String name) {
        return item -> {
            System.out.println(String.format("%s: %s", name, item));
        };
    }
}
