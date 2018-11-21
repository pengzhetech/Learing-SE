package com.javaman.thread.jiou;

/**
 * @author pengzhe
 * @date 2018/7/4 10:07
 * @description
 */

public class PrintQi implements Runnable {

    Resource resource;

    public PrintQi(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (resource.i <= 100) {
            synchronized (resource) {
                if (resource.flag) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("奇数:" + resource.i);
                    resource.i++;
                    resource.flag = true;
                    resource.notifyAll();
                }

            }
        }
    }
}
