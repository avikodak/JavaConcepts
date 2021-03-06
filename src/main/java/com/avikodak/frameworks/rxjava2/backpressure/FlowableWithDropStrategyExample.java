package com.avikodak.frameworks.rxjava2.backpressure;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;

public class FlowableWithDropStrategyExample {

    public static void main(String[] args) {
        Flowable<Integer> source = Flowable.create(flowableEmitter -> {
            for (int counter = 0; counter < 1000; counter++) {
                if (flowableEmitter.isCancelled()) {
                    return;
                }
                flowableEmitter.onNext(counter);
            }
            flowableEmitter.onComplete();
        }, BackpressureStrategy.DROP);
        source.observeOn(Schedulers.io());
        source.subscribe(value -> {
            Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(50));
            System.out.println("Received value :" + value);
        });
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1000));
    }
}
