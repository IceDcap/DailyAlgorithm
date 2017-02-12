package com.icedcap.datastruction;

/**
 * Created by doushuqi on 17-2-10.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
