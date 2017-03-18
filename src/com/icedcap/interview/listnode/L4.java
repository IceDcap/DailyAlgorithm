package com.icedcap.interview.listnode;

import com.icedcap.datastruction.DoubleNode;
import com.icedcap.datastruction.Helper;
import com.icedcap.datastruction.ListNode;

/**
 * 反转单链表和双链表
 */
public class L4 {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = head, pre = null;
        while (dummy != null) {
            ListNode next = dummy.next;
            dummy.next = pre;
            pre = dummy;
            dummy = next;
        }
        return pre;
    }

    public static DoubleNode reverse(DoubleNode head) {
        if (head == null || head.next == null) return head;
        DoubleNode pre = null;
        while (head != null) {
            DoubleNode next = head.next;
            head.next = pre;
            head.prev = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Helper.printListNode(reverse(head));
    }
}
