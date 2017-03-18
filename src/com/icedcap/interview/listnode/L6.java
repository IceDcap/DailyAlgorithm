package com.icedcap.interview.listnode;

import com.icedcap.datastruction.Helper;
import com.icedcap.datastruction.ListNode;

/**
 * 环形单链表的约瑟夫问题
 * 输入：一个环形单链表的head和报数m
 * 输出：最后生存下来的节点，且这个节点自己组成环形单向链表，其他的节点都删掉
 * 进阶：
 * 如果链表节点数为N，想在时间复杂度为O(N)下完成，该如何实现？
 */
public class L6 {

    public static ListNode getSurvive(ListNode head, int m) {
        if (head == null || head.next == head || m < 1) return head;
        //先找到尾指针
        ListNode tailNode = head.next;
        while (tailNode.next != head) {
            tailNode = tailNode.next;
        }
        int count = 0;
        while (head != tailNode) {
            if (++count == m) {
                tailNode.next = head.next;
                count = 0;
            } else {
                tailNode = tailNode.next;
            }
            head = tailNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;
        Helper.printListNode(getSurvive(head, 3));
    }
}
