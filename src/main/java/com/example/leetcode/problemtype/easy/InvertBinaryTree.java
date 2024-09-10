package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * Leetcode link : https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root != null) {
            TreeNode tempRight = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(tempRight);
        }
        return root;

    }
}
