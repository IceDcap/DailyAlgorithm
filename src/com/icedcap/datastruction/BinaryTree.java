package com.icedcap.datastruction;

/**
 * Created by icedcap on 18/03/2017.
 */
public class BinaryTree {

    public int val;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
