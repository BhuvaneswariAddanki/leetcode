package com.example.leetcode.sep18;

import com.example.leetcode.tree.binarytree.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);

    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        return helper(node.left, lower, val) && helper(node.right, val, upper);

    }
}
