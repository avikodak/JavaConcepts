package com.avikodak.designpatterns.examples.concurrency.semaphore.fruitshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Customer extends Thread {

    private static final Logger log = LoggerFactory.getLogger(Customer.class);

    private String name;

    private FruitShop fruitShop;

    private FruitBowl fruitBowl;

    public Customer(String name, FruitShop fruitShop) {
        this.name = name;
        this.fruitShop = fruitShop;
        this.fruitBowl = new FruitBowl();
    }

    public void run() {
        while(fruitShop.countFruits() > 0) {
            Optional<FruitBowl> shopFruitBowl = fruitShop.takeBowl();
            if(shopFruitBowl.isPresent()) {
                Optional<Fruit> fruit = shopFruitBowl.get().takeFruit();
                if(fruit.isPresent()) {
                    log.info("{} took fruit an {}", name, fruit.get());
                    fruitBowl.putFruit(fruit.get());
                    fruitShop.returnBowl(shopFruitBowl.get());
                }
            }
        }
        log.info("{} took {}", name, fruitBowl);
    }
}
