package com.avikodak.designpatterns.examples.concurrency.mutex.thief;

public class App {

    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        Jar jar = new Jar(mutex, 50);

        new Thief("A", jar).start();
        new Thief("B", jar).start();
        new Thief("C", jar).start();
    }
}
