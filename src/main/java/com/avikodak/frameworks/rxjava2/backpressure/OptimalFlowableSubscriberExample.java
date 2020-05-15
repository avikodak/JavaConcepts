package com.avikodak.frameworks.rxjava2.backpressure;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class OptimalFlowableSubscriberExample {

    public static void main(String[] args) {
        Flowable.range(1, 1000)
                .doOnNext(s -> System.out.println("Source pushed "
                        + s))
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(new Subscriber<Integer>() {
                    Subscription subscription;
                    AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        System.out.println("Requesting 40 items");
                        subscription.request(40);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(50));
                        System.out.println("Subscriber received " + integer);
                        if (count.incrementAndGet() % 20 == 0 || count.get() >= 40) {
                            System.out.println("Requested additional 20 items");
                            subscription.request(20);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println(throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done !");
                    }
                });
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1000));
    }

    private static <T> T intenseCalculation(T value) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(ThreadLocalRandom.current().nextInt(0, 5)));
        return value;
    }
}
