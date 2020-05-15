package com.avikodak.frameworks.rxjava2.backpressure;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class FlowableWithSubscriberExample {

    public static void main(String[] args) {
        Flowable.range(1, 1000)
                .doOnNext(s -> System.out.println("Source pushed :" + s))
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer value) {
                        Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(50));
                        System.out.println("Received value :" + value);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println(throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(100));
    }

    private static <T> T intenseCalculation(T value) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(ThreadLocalRandom.current().nextInt(0,5)));
        return value;
    }
}
