package com.javaman.struct.tree;

import org.junit.Test;

/**
 * @author pengzhe
 * @date 2018/4/20 17:50
 * @description
 */

public class TestBinaryTree {

    @Test
    public void test() {

        BinaryTree tree = new BinaryTree("data");
        System.out.println(tree.left);
        System.out.println(tree.right);
        System.out.println(tree.data);



    }
}
