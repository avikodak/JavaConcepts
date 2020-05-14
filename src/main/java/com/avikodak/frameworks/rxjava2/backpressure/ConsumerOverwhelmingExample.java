package com.avikodak.frameworks.rxjava2.backpressure;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.Duration;

public class ConsumerOverwhelmingExample {

    public static void main(String[] args) {
        Observable.range(1, 999_999_999)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item-> {
                    Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(50));
                    System.out.println("Received item "+ item.id);
                });
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(100000));
    }

    static class Item {
        public int id;

        Item(int id) {
            this.id = id;
            System.out.println("Constructing item "+ id);
        }
    }
}
