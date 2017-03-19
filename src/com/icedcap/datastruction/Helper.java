package com.icedcap.datastruction;

/**
 * Created by icedcap on 16/03/2017.
 */
public class Helper {
    public static void printListNode(ListNode head) {
        while (head!=null) {
            System.out.println(String.valueOf(head.val));
            head = head.next;
        }
    }

    public static void printListNode(RandNode head) {
        while (head!=null) {
            System.out.println(String.valueOf(head.val));
            head = head.next;
        }
    }

    public static ListNode reserve(ListNode head) {
        if (head == null||head.next == null) return head;
        ListNode pre = null;
        while (head!=null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
