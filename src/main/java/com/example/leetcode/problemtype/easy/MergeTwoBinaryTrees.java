package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * 617. Merge Two Binary Trees
 * Easy
 * Topics
 * Companies
 * <p>
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * <p>
 * Example 2:
 * <p>
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 2000].
 * -104 <= Node.val <= 104
 * <p>
 * Leetcode link : https://leetcode.com/problems/merge-two-binary-trees/description/
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode result = null;
        if (root1 != null && root2 != null) {
            result = new TreeNode(root1.val + root2.val);
            result.left = mergeTrees(root1.left, root2.left);
            result.right = mergeTrees(root1.right, root2.right);
        } else if (root2 != null) {
            result = new TreeNode(root2.val);
            result.left = mergeTrees(null, root2.left);
            result.right = mergeTrees(null, root2.right);
        } else if (root1 != null) {
            result = new TreeNode(root1.val);
            result.left = mergeTrees(root1.left, null);
            result.right = mergeTrees(root1.right, null);
        }
        return result;

    }
}
