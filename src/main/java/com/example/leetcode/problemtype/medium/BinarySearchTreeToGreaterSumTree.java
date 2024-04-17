package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [0,null,1]
 * Output: [1,null,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 100].
 * 0 <= Node.val <= 100
 * All the values in the tree are unique.
 * <p>
 * Leetcode link : https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
 */
public class BinarySearchTreeToGreaterSumTree {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        return descendingOrderTraversal(root);
    }

    public TreeNode descendingOrderTraversal(TreeNode node) {
        if (node != null) {
            node.right = descendingOrderTraversal(node.right);
            sum += node.val;
            node.val = sum;
            node.left = descendingOrderTraversal(node.left);
            return node;
        }
        return null;
    }
}
