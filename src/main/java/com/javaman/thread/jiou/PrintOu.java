package com.javaman.thread.jiou;

/**
 * @author pengzhe
 * @date 2018/7/4 10:11
 * @description
 */

public class PrintOu implements Runnable {

    Resource resource;

    public PrintOu(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (resource.i <= 100) {
            //必须是一把锁
            synchronized (resource) {
                if (!resource.flag) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("偶数:" + resource.i);
                    resource.i++;
                    resource.flag = false;
                    resource.notifyAll();
                }
            }
        }

    }
}
