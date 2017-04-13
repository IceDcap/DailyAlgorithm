package com.icedcap.leetcode.bfs;

import com.icedcap.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. Find Bottom Left Tree Value(M)
 * <p>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class S513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new S513().findBottomLeftValue(root));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.left.left = new TreeNode(7);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);
        System.out.println(new S513().findBottomLeftValue(root2));
    }
}
