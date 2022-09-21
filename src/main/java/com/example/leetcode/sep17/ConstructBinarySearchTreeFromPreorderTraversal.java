package com.example.leetcode.sep17;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertNode(root, preorder[i]);
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
