package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 * <p>
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * <p>
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 *
 * Leetcode link : https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 */
public class SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {

        return search(root, val);

    }

    private TreeNode search(TreeNode node, int val) {

        if (node == null) {
            return null;
        } else {
            if (node.val == val) {
                return node;
            } else if (val > node.val) {
                return searchBST(node.right, val);
            } else {
                return searchBST(node.left, val);
            }
        }
    }

}
