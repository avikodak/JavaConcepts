package com.avikodak.frameworks.rxjava2.operators.collections;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;

public class CollectExample {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta")
                .collect(ImmutableList::builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(immutableList-> System.out.println(immutableList));
    }
}
