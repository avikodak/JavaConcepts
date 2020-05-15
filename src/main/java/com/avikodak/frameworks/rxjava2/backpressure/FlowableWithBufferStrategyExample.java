package com.avikodak.frameworks.rxjava2.backpressure;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;

public class FlowableWithBufferStrategyExample {

    public static void main(String[] args) {
        Flowable<Integer> source = Flowable.create(flowableEmitter -> {
            for (int counter = 0; counter < 1000; counter++) {
                if(flowableEmitter.isCancelled()) {
                    return;
                }
                flowableEmitter.onNext(counter);
            }
            flowableEmitter.onComplete();}, BackpressureStrategy.BUFFER);
        source.observeOn(Schedulers.io());
        source.subscribe(System.out::println);

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1000));
    }
}
