package com.icedcap.interview.listnode;

import com.icedcap.datastruction.ListNode;

/**
 * 删除链表中间节点和a/b处的节点
 */
public class L3 {

    public ListNode removeMidNode(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) return head.next;
        ListNode pre = head;
        ListNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public ListNode removeNodeByRatio(ListNode head, int a, int b) {
        //思路：
        //将要删除的节点为（a/b * n）向上取整，n代表链表长度
        if (head == null || a < 1 || a > b) return head;
        int len = 0;
        ListNode dummy = head;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }
        int pendingRemovePos = (int) Math.ceil((double) (a * len) / (double) b);
        if (pendingRemovePos == 1) return head.next;
        if (pendingRemovePos > 1) {
            dummy = head;
            while (--pendingRemovePos != 1) {
                dummy = dummy.next;
            }
            dummy.next = dummy.next.next;
        }
        return head;
    }
}
