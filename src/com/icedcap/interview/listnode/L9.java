package com.icedcap.interview.listnode;

import com.icedcap.datastruction.Helper;
import com.icedcap.datastruction.RandNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含随机指针节点的链表
 */
public class L9 {

    public RandNode copyRandNode(RandNode head) {
        Map<RandNode, RandNode> map = new HashMap<>();
        RandNode dummy = head;
        while (dummy != null) {
            map.put(dummy, new RandNode(dummy.val));
            dummy = dummy.next;
        }
        dummy = head;
        while (dummy != null) {
            map.get(dummy).next = map.get(dummy.next);
            map.get(dummy).rand = map.get(dummy.rand);
            dummy = dummy.next;
        }
        return map.get(head);
    }

    // 1->1'->2->2'->3->3'->null
    public RandNode copyRandNodePro(RandNode head) {
        RandNode dummy = head;
        while (dummy != null) {
            RandNode next = dummy.next;
            RandNode copy = new RandNode(dummy.val);
            dummy.next = copy;
            copy.next = next;
            dummy = next;
        }

        dummy = head;
        while (dummy != null && dummy.next != null) {
            RandNode rand = dummy.rand;
            if (rand != null) {
                dummy.next.rand = dummy.rand.next;
            }
            dummy = dummy.next;
        }

        dummy = head.next;
        while (dummy != null && dummy.next != null) {
            RandNode next = dummy.next.next;
            dummy.next.next = null;
            dummy.next = next;
            dummy = next;
        }
        RandNode node = head.next;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        RandNode head = new RandNode(1);
        head.next = new RandNode(2);
        head.next.next = new RandNode(3);
        head.rand = head.next.next;
        head.next.rand = null;
        head.next.next.rand = head;
        RandNode node = new L9().copyRandNodePro(head);
        Helper.printListNode(node);
        System.out.println("-------------");
        while (node != null) {
            System.out.println(node.rand);
            node = node.next;
        }
    }
}
