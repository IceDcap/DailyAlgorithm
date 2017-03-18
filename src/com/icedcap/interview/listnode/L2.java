package com.icedcap.interview.listnode;

import com.icedcap.datastruction.DoubleNode;
import com.icedcap.datastruction.ListNode;

/**
 * 在单链表中和双链表中删除倒数第k个节点
 * 分别实现两个函数一个可以删除单链表的倒数第k个节点，一个可以删除双链表倒数第k个节点
 * 如果链表长度为N，时间复杂度为O(N)，额外空间复杂度为O(1)
 */
public class L2 {

    public static ListNode removeLastKthNode(ListNode head, int k) {
        if (head == null || k < 1) return head;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            k--;
        }
        if (k == 0) {
            head = head.next;
        } else if (k > 0) {
        } else {
            dummy = head;
            while (++k != 0) {
                dummy = dummy.next;
            }
            dummy.next = dummy.next.next;
        }
        return head;
    }

    public static DoubleNode removeLastKthNode(DoubleNode head, int k) {
        if (head == null || k < 1) return head;
        DoubleNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            k--;
        }

        if (k > 0) {
            return head;
        } else if (k == 0) {
            return head.next;
        } else {
            dummy = head;
            while (++k != 0) {
                dummy = dummy.next;
            }
            DoubleNode node = dummy.next.next;
            dummy.next = node;
            if (node != null) {
                node.prev = dummy;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(42);
        head.next.next = new ListNode(24);
        head.next.next.next = new ListNode(13);
        head.next.next.next.next = new ListNode(8);

        ListNode newHead = removeLastKthNode(head, 5);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
