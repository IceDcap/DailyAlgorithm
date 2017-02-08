package com.icedcap.SumRoottoLeafNumbers;

/**
 * 129. Sum Root to Leaf Numbers(M)
 * <p>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 *   1
 *  / \
 * 2   3
 * <p>
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sum(root, 0);
    }

    private int sum(TreeNode root, int s) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return s * 10 + root.val;
        else return sum(root.left, s * 10 + root.val) + sum(root.right, s * 10 + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().sumNumbers(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
