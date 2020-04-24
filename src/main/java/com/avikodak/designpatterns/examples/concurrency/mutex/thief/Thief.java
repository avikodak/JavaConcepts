package com.avikodak.designpatterns.examples.concurrency.mutex.thief;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thief extends Thread {

    private static final Logger log = LoggerFactory.getLogger(Thief.class);

    private String name;
    private Jar jar;

    public Thief(String name, Jar jar) {
        this.name = name;
        this.jar = jar;
    }

    public void run() {
        int beans = 0;
        while(jar.takeBean()) {
            beans = beans + 1;
            log.info("{} took a bean.", name);
        }
        log.info("{} thief took {} beans", name, beans);
    }
}
