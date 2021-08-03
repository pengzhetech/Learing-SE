package com.javaman.thread.array;


import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengzhe
 * @date 2021/8/3 22:26
 * @description
 */

public class ABCPrint {


    public static void main(String[] args) {

        Data2 data2 = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                data2.PrintA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                data2.PrintB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                data2.PrintC();
            }
        }).start();
    }

}

class Data2 {

    private char chars = 'A';
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void PrintA() {
        lock.lock();
        try {
            while (chars != 'A') {
                //等待
                condition1.await();
            }
            System.out.print(chars);
            chars = 'B';
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void PrintB() {
        lock.lock();
        try {
            while (chars != 'B') {
                condition2.await();
            }
            System.out.print(chars);
            chars = 'C';
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void PrintC() {
        lock.lock();
        try {
            while (chars != 'C') {
                condition3.await();
            }
            System.out.print(chars);
            chars = 'A';
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
