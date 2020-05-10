package com.avikodak.frameworks.rxjava2.flowables;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlowableGenerateExample {

    public static void main(String[] args) {
        Flowable.generate(() -> 0l, (state, emitter) -> {
                    emitter.onNext(state);
                    return state + 1; })
                .subscribeOn(Schedulers.io())
                .doOnNext(t -> System.out.println("Producing :" + t))
                .observeOn(Schedulers.io())
                .subscribe(t -> {
                    Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(500));
                    System.out.println("Received :" + t);
                });


        Uninterruptibles.sleepUninterruptibly(Duration.ofMinutes(30));
    }

}
