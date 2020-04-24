package com.avikodak.designpatterns.examples.concurrency.semaphore.fruitshop;

public class App {

    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();
        new Customer("A", fruitShop).start();
        new Customer("B", fruitShop).start();
        new Customer("C", fruitShop).start();
        new Customer("D", fruitShop).start();
        new Customer("E", fruitShop).start();
    }
}
