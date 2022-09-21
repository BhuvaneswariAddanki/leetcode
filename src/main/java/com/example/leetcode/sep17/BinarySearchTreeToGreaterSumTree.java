package com.example.leetcode.sep17;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.Stack;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        BinarySearchTreeToGreaterSumTree object = new BinarySearchTreeToGreaterSumTree();
        object.bstToGst(root);
        System.out.println(root);

    }

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

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }
}


