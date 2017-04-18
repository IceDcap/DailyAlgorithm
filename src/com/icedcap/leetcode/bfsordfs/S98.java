package com.icedcap.leetcode.bfsordfs;

import com.icedcap.leetcode.tree.TreeNode;

/**
 * 98. Validate Binary Search Tree(M)
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 */
public class S98 {
    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    private boolean help(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        return (low == null || root.val > low) &&
                (high == null || root.val < high) &&
                help(root.left, low, root.val) &&
                help(root.right, root.val, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new S98().isValidBST(root));
    }
}
