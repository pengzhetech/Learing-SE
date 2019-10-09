package com.javaman.function;

/**
 * @author pengzhe
 * @date 2019-05-23 17:13
 */
public class Father {

    private String fatherPrivate() {
        return "OK fatherPrivate";
    }

    protected String fatherProtected() {
        return "OK fatherProtected";
    }

    protected final String fatherFinal() {
        return "OK fatherFinal protected";
    }
}
