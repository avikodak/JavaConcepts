package com.avikodak.frameworks.rxjava2.backpressure;

import com.google.common.util.concurrent.Uninterruptibles;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class NoBackupPressureExample {

    public static void main(String[] args) {
        // Since this is running on main thread we consumer won't get overwhelmed with emission
        Observable.range(1, 999_999_999)
                .map(Item::new)
                .subscribe(myItem -> {
                    Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
                    System.out.println("Received MyItem " +
                            myItem.id);
                });

    }

    static final class Item {
        final int id;

        Item(int id) {
            this.id = id;
            System.out.println("Constructing MyItem " + id);
        }
    }
}
