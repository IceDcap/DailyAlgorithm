package com.icedcap.interview.listnode;

import com.icedcap.datastruction.Helper;
import com.icedcap.datastruction.ListNode;

/**
 * 单链表选择排序
 */
public class L12 {

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode dummy = newHead;
        while (head != null && head.next != null) {
            ListNode minNode = head;
            ListNode right = head.next;
            while (right != null) {
                if (right.val < minNode.val) {
                    minNode = right;
                }
                right = right.next;
            }
            ListNode preMinNode = findPreMinNode(head, minNode);
            if (preMinNode == null) {
                head = head.next;
            } else {
                preMinNode.next = minNode.next;
            }
            minNode.next = null;
            dummy.next = minNode;
            dummy = dummy.next;
        }
        if (head!= null) {
            dummy.next = head;
        }
        return newHead.next;
    }

    private ListNode findPreMinNode(ListNode head, ListNode target) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            if (head.val == target.val) {
                return pre;
            }
            pre = pre.next;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(2);

//        Helper.printListNode(head);
        Helper.printListNode(new L12().sort(head));
    }
}
