package com.avikodak.designpatterns.examples.concurrency.semaphore.fruitshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class FruitShop {

    private static final Logger log = LoggerFactory.getLogger(FruitShop.class);

    private FruitBowl[] fruitBowls = {
            new FruitBowl(),
            new FruitBowl(),
            new FruitBowl()
    };

    private boolean[] available = {
            true,
            true,
            true
    };

    private Semaphore semaphore;

    public FruitShop() {
        for(int counter = 0;counter < 10;counter++) {
            fruitBowls[0].putFruit(new Fruit(Fruit.FruitType.APPLE));
            fruitBowls[1].putFruit(new Fruit(Fruit.FruitType.ORANGE));
            fruitBowls[2].putFruit(new Fruit(Fruit.FruitType.BANANA));
        }
        semaphore = new Semaphore(3);
    }

    public synchronized int countFruits() {
        return fruitBowls[0].countFruits() + fruitBowls[1].countFruits() + fruitBowls[2].countFruits();
    }

    public synchronized Optional<FruitBowl> takeBowl() {
        Optional<FruitBowl> fruitBowl = Optional.empty();
        try {
            semaphore.acquire();
            if(available[0]) {
                fruitBowl = Optional.of(fruitBowls[0]);
                available[0] = false;
            } else if(available[1]) {
                fruitBowl = Optional.of(fruitBowls[1]);
                available[1] = false;
            } else if(available[2]) {
                fruitBowl = Optional.of(fruitBowls[2]);
                available[2] = false;
            }
        } catch(InterruptedException e) {
            log.error("Got interrupted while acquiring semaphore", e);
        } finally {
            semaphore.release();
        }
        return fruitBowl;
    }

    public synchronized void returnBowl(FruitBowl fruitBowl) {
        if(fruitBowl == fruitBowls[0]) {
            available[0] = true;
        } else if(fruitBowl == fruitBowls[1]) {
            available[1] = true;
        } else {
            available[2] = true;
        }
    }
}
