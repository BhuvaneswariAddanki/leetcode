package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * ex: Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || (isSymmetric(root.left, root.right));
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
