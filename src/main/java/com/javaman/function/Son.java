package com.javaman.function;

/**
 * @author pengzhe
 * @date 2019-05-23 17:15
 */
public class Son extends Father {

    @Override
    protected String fatherProtected() {
        return super.fatherProtected();
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.fatherFinal());
    }
}
