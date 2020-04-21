package com.avikodak.designpatterns.concurrency.semaphore;

public class Fruit {

    public enum FruitType{
        ORANGE,
        APPLE,
        BANANA
    }

    private FruitType fruitType;

    public Fruit(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public FruitType getType() {
        return fruitType;
    }

    @Override
    public String toString() {
        return fruitType.name();
    }
}
