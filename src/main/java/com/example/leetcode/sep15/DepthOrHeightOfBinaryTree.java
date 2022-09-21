package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class DepthOrHeightOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(8),
                                new TreeNode(9,
                                        new TreeNode(10,
                                                null,
                                                new TreeNode(11)),
                                        null))),
                new TreeNode(3,
                        new TreeNode(6,
                                null,
                                new TreeNode(14))
                        , new TreeNode(7,
                        null,
                        new TreeNode(12,
                                new TreeNode(13,
                                        null,
                                        new TreeNode(15)),
                                null))));
        DepthOrHeightOfBinaryTree depthOrHeightOfBinaryTree = new DepthOrHeightOfBinaryTree();
       int depth =  depthOrHeightOfBinaryTree.maxDepthOfTree(root);
       System.out.println(depth);
    }

    public int maxDepthOfTree(TreeNode root) {
        return depthOfTree(root, 0);
    }

    private int depthOfTree(TreeNode node, int depth) {
        if (node != null) {
            return Math.max(depthOfTree(node.left, depth + 1), depthOfTree(node.right, depth + 1));
        }
        return depth;
    }

}
