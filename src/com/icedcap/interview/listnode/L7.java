package com.icedcap.interview.listnode;

import com.icedcap.datastruction.Helper;
import com.icedcap.datastruction.ListNode;

import java.util.Stack;

/**
 * 判断一个链表是否为回文
 */
public class L7 {

    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode dummy = head;
        while (dummy != null) {
            stack.push(dummy.val);
            dummy = dummy.next;
        }
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //优化方法一，只入栈一半元素
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        //使用一个左右指针，找到后半部分的起点
        ListNode start = head, right = head.next;
        while (start.next != null && start.next.next != null) {
            right = right.next;//走一步
            start = start.next.next;//走两步
        }
        Stack<Integer> stack = new Stack<>();
        while (right != null) {
            stack.push(right.val);
            right = right.next;
        }

        while (!stack.empty()) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //空间复杂度O(1)，取中点，反转后半部分，遍历对比，最后恢复链表原有结构
    public static boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode n1 = head, n2 = head;
        while (n1.next != null && n1.next.next != null) {
            n1 = n1.next.next;
            n2 = n2.next;//中部
        }
        ListNode rightHead = n2.next;
        ListNode leftTail = n2;
        n2.next = null;
        //反转右部分
        ListNode reverseHead = reverse(rightHead);
        n2 = reverseHead;//右边第一个
        n1 = head;//左边第一个节点
        boolean result = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                result = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //恢复链表
        leftTail.next = reverse(reverseHead);
        return result;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome3(head));
        Helper.printListNode(head);
    }
}
