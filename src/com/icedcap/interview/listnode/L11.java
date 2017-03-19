package com.icedcap.interview.listnode;

import com.icedcap.datastruction.BinaryTree;
import com.icedcap.datastruction.DoubleNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转化为双链表
 */
public class L11 {

    public BinaryTree convert(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        inOrderToQueue(root, queue);
        if (queue.isEmpty()) return root;
        BinaryTree head = queue.poll();
        BinaryTree pre = head;
        pre.left = null;
        BinaryTree cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;

        return head;
    }

    //中序入队列
    private void inOrderToQueue(BinaryTree root, Queue<BinaryTree> queue) {
        if (root == null) {
            return;
        }
        inOrderToQueue(root.left, queue);
        queue.offer(root);
        inOrderToQueue(root.right, queue);
    }
}
