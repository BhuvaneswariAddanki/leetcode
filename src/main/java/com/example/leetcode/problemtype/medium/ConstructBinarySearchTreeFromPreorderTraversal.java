package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
 * <p>
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 * <p>
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
 * <p>
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: preorder = [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * Example 2:
 * <p>
 * Input: preorder = [1,3]
 * Output: [1,null,3]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 1000
 * All the values of preorder are unique.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    int currentIndex = 0;

    public TreeNode bstFromPreorder(int[] arr) {
        return helper(arr, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] arr, int bound) {
        if (currentIndex == arr.length || arr[currentIndex] > bound) return null;
        TreeNode root = new TreeNode(arr[currentIndex++]);
        root.left = helper(arr, root.val);
        root.right = helper(arr, bound);
        return root;
    }

    public TreeNode bstFromPreorder2(int[] preorder) {
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

    public TreeNode bstFromPreorder3(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) return root;
        int index = left + 1;
        while (index <= right && preorder[index] < root.val) {
            index++;
        }
        root.left = helper(preorder, left + 1, index - 1);
        root.right = helper(preorder, index, right);
        return root;
    }
}


