package com.icedcap.interview.listnode;

import com.icedcap.datastruction.Helper;
import com.icedcap.datastruction.ListNode;

/**
 * 将单向链表按某值划分为左边小中间相等右边大的形式
 * 进阶：前后两部分按原有的顺序排列
 */
public class L8 {
    public ListNode partitionList1(ListNode head, int pivot) {
        if (head == null || head.next == null) return head;
        ListNode dummy = head;
        int len = 0;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }
        ListNode[] listArray = new ListNode[len];
        dummy = head;
        for (int i = 0; i < len; i++) {
            listArray[i] = dummy;
            dummy = dummy.next;
        }
        partitionArray(listArray, pivot);
        for (int i = 1; i != len; i++) {
            listArray[i - 1].next = listArray[i];
        }
        listArray[len - 1].next = null;
        return listArray[0];
    }

    private void partitionArray(ListNode[] array, int pivot) {
        int left = 0, right = array.length - 1, index = 0;
        while (index <= right) {
            if (array[index].val > pivot) {
                swap(array, index, right--);
            } else if (array[index].val == pivot) {
                index++;
            } else {
                swap(array, left++, index++);
            }
        }
    }

    private void swap(ListNode[] array, int a, int b) {
        ListNode temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(9);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);

        Helper.printListNode(new L8().partitionList2(head, 7));
    }

    //进阶
    public ListNode partitionList2(ListNode head, int pivot) {
        ListNode sH = null;//小于部分的头指针
        ListNode sT = null;//小于部分的尾指针
        ListNode eH = null;//相等部分的头指针
        ListNode eT = null;//相等部分的尾指针
        ListNode bH = null;//大于部分的头指针
        ListNode bT = null;//大于部分的尾指针

        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;
    }
}
