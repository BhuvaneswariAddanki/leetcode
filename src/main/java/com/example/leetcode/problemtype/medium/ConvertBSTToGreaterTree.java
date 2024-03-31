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
 * The number of nodes in the tree is in the range [0, 104].
 * -104 <= Node.val <= 104
 * All the values in the tree are unique.
 * root is guaranteed to be a valid binary search tree.
 * <p>
 * Leetcode link  :https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 */
public class ConvertBSTToGreaterTree {
    int latestSum = 0;

    public TreeNode convertBST(TreeNode current) {
        if (current != null) {
            current.right = convertBST(current.right);
            current.val = current.val + latestSum;
            latestSum = current.val;
            current.left = convertBST(current.left);
        }
        return current;
    }

    public TreeNode convertBST2(TreeNode current) {
        return go(current, new int[]{0});
    }

    public TreeNode go(TreeNode current, int[] sum) {
        if (current != null) {
            current.right = go(current.right, sum);
            current.val = current.val + sum[0];
            sum[0] = current.val;
            current.left = go(current.left, sum);
        }
        return current;
    }
}

