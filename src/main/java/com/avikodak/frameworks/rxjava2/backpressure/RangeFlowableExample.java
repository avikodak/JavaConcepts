package com.avikodak.frameworks.rxjava2.backpressure;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;

public class RangeFlowableExample {

    public static void main(String[] args) {
        Flowable.range(1, 999_999_999)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(50));
                    System.out.println("Received item " + item.id);
                });

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10000));
    }

    static class Item {
        public int id;

        Item(int id) {
            this.id = id;
            System.out.println("Constructing item with id "+ id);
        }
    }
}
