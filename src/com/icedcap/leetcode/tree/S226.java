package com.icedcap.leetcode.tree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. Invert Binary Tree(E)
 *
 * Invert a binary tree.
 *
 *        4
 *      /   \
 *     2     7
 *    / \   / \
 *   1   3 6   9
 * to
 *        4
 *      /   \
 *     7     2
 *    / \   / \
 *   9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 */
public class S226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        final TreeNode left = root.left;
        final TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode result = new S226().invertTree3(root);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.left.right.val);
        System.out.println(result.right.left.val);
        System.out.println(result.right.right.val);
    }
}
