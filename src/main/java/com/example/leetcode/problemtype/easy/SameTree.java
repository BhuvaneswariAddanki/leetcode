package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * leetcode link : https://leetcode.com/problems/same-tree/description/
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameNode(p, q);
    }

    private boolean isSameNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSameNode(node1.left, node2.left) && isSameNode(node1.right, node2.right);
    }
}

