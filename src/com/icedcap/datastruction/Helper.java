package com.icedcap.datastruction;

/**
 * Created by icedcap on 16/03/2017.
 */
public class Helper {
    public static void printListNode(ListNode head) {
        while (head!=null) {
            System.out.println(String.valueOf(head.val));
            head = head.next;
        }
    }
}
