package com.javaman.struct.tree;

/**
 * @author pengzhe
 * @date 2018/4/20 17:45
 * @description Java实现二叉树
 * <p>
 * 当我们要实现二叉树时,我们需要牢记的第一件事是它是一个结点集合。
 * 每个结点都有三个属性：value,left_child,和right_child
 */

public class BinaryTree {
    /**
     * 左孩子节点
     */
    public BinaryTree left;
    /**
     * 右孩子节点
     */
    public BinaryTree right;
    /**
     * 树的内容
     */
    public String data;

    public BinaryTree() {
    }

    /**
     * 构造方法
     *
     * @param data
     * @param left
     * @param right
     */
    public BinaryTree(String data, BinaryTree left, BinaryTree right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    /**
     * 构造方法
     *
     * @param data
     */
    public BinaryTree(String data) {
        this(data, null, null);
    }

}
