package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.Stack;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 1000].
 * -231 <= Node.val <= 231 - 1
 * <p>
 * <p>
 * Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 * <p>
 * Leetcode link : https://leetcode.com/problems/recover-binary-search-tree/description/
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        obj.recoverTree(root);
    }


    private TreeNode prev;
    private TreeNode first;
    private TreeNode second;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        dfs(root.right);
    }

    public void recoverTreeIteration(TreeNode root) {

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
