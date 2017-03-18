package com.icedcap.interview.listnode;

import com.icedcap.datastruction.ListNode;

/**
 * 打印两个链表的公共部分
 */
public class L1 {

    public void printPublicElementFromTwoOrderListNode(ListNode head1, ListNode head2) {
        //要不要改变两个链表的头结点即head1和head2？
        ListNode temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val< temp2.val) {
                temp1 = temp1.next;
            } else if (temp1.val> temp2.val) {
                temp2 = temp2.next;
            } else {
                System.out.println(temp1.val);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
    }

    public static void main(String args[]) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(20);
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(20);
        head2.next.next.next.next = new ListNode(33);
        new L1().printPublicElementFromTwoOrderListNode(head1, head2);
    }
}
