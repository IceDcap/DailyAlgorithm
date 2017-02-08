package com.icedcap.InsertionSortList;

/**
 * 147. Insertion Sort List(M)
 * <p>
 * Sort a linked list using insertion sort.
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preNode = new ListNode(-1);
        while (head != null) {
            ListNode cur = preNode;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            ListNode next = head.next;
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return preNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(7);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(10);

        ListNode result = new Solution().insertionSortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
