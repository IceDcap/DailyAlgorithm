package com.icedcap.leetcode.bfsordfs;

import com.icedcap.leetcode.tree.TreeNode;

import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal(M)
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class S106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    public static TreeNode constructCore(int[] preOrder, int[] inOrder,
                                         int startPreIndex, int endPreIndex,
                                         int startInIndex, int endInIndex) {
        //前序第一个元素即为根节点
        int rootValue = preOrder[startPreIndex];
        TreeNode root = new TreeNode(rootValue);


        //在中序中找到根节点的值
        int rootInOrderIndex = startInIndex;
        while (rootInOrderIndex <= endInIndex) {
            if (inOrder[rootInOrderIndex] == rootValue) {
                break;
            }
            ++rootInOrderIndex;
        }

//        System.out.println(rootInOrderIndex);

        int leftLength = rootInOrderIndex - startInIndex;
        int leftEndPreIndex = startPreIndex + leftLength;

        if (rootInOrderIndex > startInIndex) {
            //构建左子树
//            System.out.println("left pre = " + (startPreIndex + 1) + " : " + leftEndPreIndex +
//                    "\tin = " + startInIndex + " : " + (rootInOrderIndex - 1));
            root.left = constructCore(preOrder, inOrder,
                    startPreIndex + 1, leftEndPreIndex,
                    startInIndex, rootInOrderIndex - 1);

        }
        if (rootInOrderIndex < endInIndex) {
            //构建右子树
//            System.out.println("right pre = " + (leftEndPreIndex + 1) + " : " + endPreIndex +
//                    "\tin = " + (rootInOrderIndex + 1) + " : " + (endInIndex));
            root.right = constructCore(preOrder, inOrder,
                    leftEndPreIndex + 1, endPreIndex,
                    rootInOrderIndex + 1, endInIndex);
        }

        return root;
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, hm);
        TreeNode rightchild = buildTreePostIn(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
