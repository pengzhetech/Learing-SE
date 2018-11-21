package com.javaman.thread.array;

import java.util.concurrent.locks.Lock;

/**
 * @author pengzhe
 * @date 2018/7/4 10:33
 * @description
 */

public class PrintFirst implements Runnable {
    /**
     * 资源
     */
    String[] resource;
    /**
     * 锁
     */
    Lock lock;

    public PrintFirst(String[] resource, Lock lock) {
        this.resource = resource;
        this.lock = lock;
    }

    public void run() {


    }
}
