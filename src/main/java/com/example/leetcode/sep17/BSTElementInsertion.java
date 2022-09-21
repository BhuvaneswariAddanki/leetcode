package com.example.leetcode.sep17;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class BSTElementInsertion {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            insertNode(root, val);
        }
        return root;

    }

    private void insertNode(TreeNode node, int element) {
        if (element < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(element);
            } else {
                insertNode(node.left, element);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(element);
            } else {
                insertNode(node.right, element);
            }
        }
    }
}
