package com.example.leetcode.sep18;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.Stack;

/**
 * You are given the root of a binary search tree (BST),
 * where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(3),null);
        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {

        TreeNode prev = null;
        TreeNode first = null, second = null;
        TreeNode current = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            if (prev != null && prev.val > current.val) {
                if (first == null) {
                    first = prev;
                }
                second = current;
            }
            prev = current;
            current = current.right;
        }
        if (first != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
