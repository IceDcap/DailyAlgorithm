package com.icedcap.leetcode.SortList;

/**
 * Sort List(M)
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    //merge sort O(n log n)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //use slow/fast point to find the mid node
        //else use length of link list /2.
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow.next;
        slow.next = null;

        ListNode node1 = sortList(head);
        ListNode node2 = sortList(midNode);

        ListNode result = new ListNode(-1);
        ListNode curPoint = result;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curPoint.next = node1;
                node1 = node1.next;
            } else {
                curPoint.next = node2;
                node2 = node2.next;
            }
            curPoint = curPoint.next;
        }

        if (node1 != null) {
            curPoint.next = node1;
        }

        if (node2 != null) {
            curPoint.next = node2;
        }

        return result.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(7);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(10);

        ListNode result = new Solution().sortList(head);
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
    }
}
