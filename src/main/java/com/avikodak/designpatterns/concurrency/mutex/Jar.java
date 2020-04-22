package com.avikodak.designpatterns.concurrency.mutex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jar {

    private static final Logger log = LoggerFactory.getLogger(Jar.class);

    private Mutex mutex;

    private int beans;

    public Jar(Mutex mutex, int beans) {
        this.mutex = mutex;
        this.beans = beans;
    }

    public boolean takeBean() {
        boolean isSuccess = false;
        try {
            mutex.acquire();
            isSuccess = beans > 0;
            if (isSuccess) {
                beans = beans - 1;
            }
        } catch (InterruptedException e) {
            log.error("Got interrupted while acquiring a mutex", e);
        } finally {
            mutex.release();
        }
        return isSuccess;
    }
}
