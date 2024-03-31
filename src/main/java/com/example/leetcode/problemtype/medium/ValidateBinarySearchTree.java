package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left
 * subtree
 * of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 * <p>
 * Leetcode link : https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer lowerBound, Integer upperBound) {

        if (node == null) {
            return true;
        } else {
            int val = node.val;
            if ((lowerBound != null && val <= lowerBound) || (upperBound != null && val >= upperBound)) {
                return false;
            }
            return validate(node.left, lowerBound, val) && validate(node.right, val, upperBound);
        }
    }

}
