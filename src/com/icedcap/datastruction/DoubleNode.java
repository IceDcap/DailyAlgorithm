package com.icedcap.datastruction;

/**
 * 双链表
 */
public class DoubleNode {
    public int val;
    public DoubleNode next;
    public DoubleNode prev;

    public DoubleNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
