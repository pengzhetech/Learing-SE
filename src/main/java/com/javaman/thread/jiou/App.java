package com.javaman.thread.jiou;

/**
 * @author pengzhe
 * @date 2018/7/4 10:14
 * @description
 */

public class App {

    public static void main(String[] args) {
        Resource resource = new Resource();

        PrintQi printQi = new PrintQi(resource);
        PrintOu printOu = new PrintOu(resource);

        Thread aThread = new Thread(printQi);
        Thread bThread = new Thread(printOu);
        aThread.start();
        bThread.start();
    }


}
