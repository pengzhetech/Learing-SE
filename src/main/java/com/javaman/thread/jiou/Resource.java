package com.javaman.thread.jiou;

/**
 * @author pengzhe
 * @date 2018/7/4 10:06
 * @description 共有资源
 */

public class Resource {

    int i = 1;
    boolean flag = false;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
