package com.icedcap.AddTwoNumber2;

import java.util.Stack;

/**
 * 445. Add Two Numbers II(M)
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * <p>
 * (7243) + (564) = (7807)
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

    //考虑大数问题
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        int val1 = 0;
        while (l1 != null) {
            val1 *= 10;
            val1 += l1.val;
            l1 = l1.next;
        }
        int val2 = 0;
        while (l2 != null) {
            val2 *= 10;
            val2 += l2.val;
            l2 = l2.next;
        }
        int sum = val1 + val2;
        if (sum == 0) {
            return new ListNode(0);
        }
        ListNode result = null;
        while (sum != 0) {
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = result;
            result = tmp;
            sum /= 10;
        }

        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode result = null;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int count = 0;
        while (!s1.empty() || !s2.empty() || count != 0) {
            int v1 = s1.empty() ? 0 : s1.pop();
            int v2 = s2.empty() ? 0 : s2.pop();
            int sum = v1 + v2 + count;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = result;
            result = tmp;
            count = sum / 10;
        }

        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


