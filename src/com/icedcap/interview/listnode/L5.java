package com.icedcap.interview.listnode;

import com.icedcap.datastruction.ListNode;

/**
 * 反转部分单链表
 * 时间复杂度为O(N), 空间复杂度为O(1)
 * 如果不满足1<=from<=to<=N，则不用调整
 */
public class L5 {

    public static ListNode reversePartOfListNode(ListNode head, int from, int to) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode dummy = head;
        ListNode preFrom = null;
        ListNode nextTo = null;
        while (dummy != null) {
            len++;
            if (len == from - 1) {
                preFrom = dummy;
            }
            if (len == to + 1) {
                nextTo = dummy;
            }
            dummy = dummy.next;
        }
        if (from > to || from < 1 || to > len) return head;

        dummy = preFrom == null? head: preFrom.next;
        ListNode node1 = dummy;
        ListNode node2 = dummy.next;
        node1.next = nextTo;
        while (!node2.equals(nextTo)) {
            ListNode next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (preFrom!=null) {
            preFrom.next = node1;
            return head;
        }
        return node1;
    }
}
