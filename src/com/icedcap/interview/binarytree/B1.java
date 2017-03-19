package com.icedcap.interview.binarytree;

import com.icedcap.datastruction.BinaryTree;

import java.util.Stack;

/**
 * 分别用递归非递归实现二叉树的遍历方式
 */
public class B1 {

    public static void recursivePreOrder(BinaryTree root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

    public static void recursiveInOrder(BinaryTree root) {
        if (root == null) return;
        recursiveInOrder(root.left);
        System.out.print(root.val + " ");
        recursiveInOrder(root.right);
    }

    public static void recursivePostOrder(BinaryTree root) {
        if (root == null) return;
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public static void inOrder(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void postOrder(BinaryTree root) {
        BinaryTree node = root;
        Stack<BinaryTree> stack = new Stack<>();
        Stack<BinaryTree> output = new Stack<>();
        while (node != null || stack.size() > 0) {
            if (node!=null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            }else {
                node = stack.pop();
                node = node.left;
            }
        }
        while (!output.empty()) {
            System.out.print(output.pop().val+" ");
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        recursivePreOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println("\n----------------");
        recursiveInOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println("\n----------------");
        recursivePostOrder(root);
        System.out.println();
        postOrder(root);
    }
}
