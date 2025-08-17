package com.bigweb;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TpTest {
    @Test
    public void test() {
        int count = 20005500;
        useTp(count);
        nonUseTp(count);
    }

    public void useTp(int count) {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(count));
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            tp.execute(() -> list.add(random.nextInt()));
        }
        tp.shutdown();
        try {
            boolean awaitTermination = tp.awaitTermination(list.size(), TimeUnit.DAYS);
            System.out.println(awaitTermination);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("useTp---time--->" + (System.currentTimeMillis() - startTime));
        System.out.println("useTp---size--->" + list.size());
    }

    public void nonUseTp(int count) {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(() -> list.add(random.nextInt()));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("nonUseTp---time--->" + (System.currentTimeMillis() - startTime));
        System.out.println("nonUseTp---time--->" + list.size());
    }

    @Test
    public void test2() {
        System.out.println("Test");
    }

}
