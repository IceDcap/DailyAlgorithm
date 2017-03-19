package com.icedcap.datastruction;

/**
 * Created by icedcap on 18/03/2017.
 */
public class RandNode {
    public int val;
    public RandNode next;
    public RandNode rand;

    public RandNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
