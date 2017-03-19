package com.icedcap.interview.listnode;

import com.icedcap.datastruction.Helper;
import com.icedcap.datastruction.ListNode;

/**
 * 两个链表生成相加链表
 */
public class L10 {
    public int sumOfTwoListNode(ListNode head1, ListNode head2) {
        int num1 = 0, num2 = 0;
        while (head1 != null) {
            num1 = num1 * 10 + head1.val;
            head1 = head1.next;
        }
//        System.out.println(num1);
        while (head2 != null) {
            num2 = num2 * 10 + head2.val;
            head2 = head2.next;
        }
//        System.out.println(num2);
        return num1 + num2;
    }

    public ListNode getSumListNode(ListNode head1, ListNode head2) {
        int sum = sumOfTwoListNode(head1, head2);
        ListNode head = new ListNode(sum % 10);
        sum = sum / 10;
        ListNode dummy = head;
        while (sum > 0) {
            int val = sum % 10;
            dummy.next = new ListNode(val);
            dummy = dummy.next;
            sum /= 10;
        }
        return Helper.reserve(head);
    }


    public static void main(String args[]) {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(7);

        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(3);

        System.out.println(new L10().sumOfTwoListNode(head1, head2));
        Helper.printListNode(new L10().getSumListNode(head1, head2));
    }
}
