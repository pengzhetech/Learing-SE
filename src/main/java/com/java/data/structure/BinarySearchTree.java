package com.java.data.structure;

import java.util.NoSuchElementException;

/**
 * 二叉查找树
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    /**
     * 根节点
     */
    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * -------------------------------------------internal method-------------------------------------------/
     * /**
     * internal method to find an item in a subtree
     *
     * @param x is item to search for
     * @param t the node that roots the subtree
     * @return
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        }
        if (compareResult > 0) {
            return contains(x, t.right);
        }
        return true;
    }

    /**
     * internal method to find the smallest item in a subtree
     *
     * @param t the node that roots the subtree
     * @return node containing the smallest item
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        }
        if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    /**
     * internal method to find the largest item in a subtree
     *
     * @param t the node that roots the subtree
     * @return node containing the largest item
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    /**
     * internal method to insert into a subtree
     *
     * @param x the item to insert
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        }
        if (compareResult > 0) {
            t.right = insert(x, t.right);
        }
        return t;
    }

    /**
     * internal method to remove from a subtree
     *
     * @param x the item to remove
     * @param t the node that roots the subtree
     * @return return the new root of the subtree
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private static class BinaryNode<AnyType> {

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}

