package com.design;

import java.util.Objects;

/**
 * 并发编程三要素:原子性,可见性,顺序性
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (Objects.nonNull(instance)) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (Objects.isNull(instance)) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
