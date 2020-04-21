package com.avikodak.designpatterns.concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FruitBowl {

    private List<Fruit> fruits = new ArrayList<>();

    public int countFruits() {
        return fruits.size();
    }

    public void putFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public Optional<Fruit> takeFruit() {
        if(fruits.isEmpty()) {
            return Optional.empty();
        }else{
            return Optional.of(fruits.remove(0));
        }
    }

    @Override
    public String toString() {
        int apples = 0;
        int oranges = 0;
        int bananas = 0;

        for (Fruit f : fruits) {
            switch (f.getType()) {
                case APPLE:
                    apples++;
                    break;
                case ORANGE:
                    oranges++;
                    break;
                case BANANA:
                    bananas++;
                    break;
                default:
            }
        }

        return apples + " Apples, " + oranges + " Oranges, and " + bananas + " Bananas";
    }
}
