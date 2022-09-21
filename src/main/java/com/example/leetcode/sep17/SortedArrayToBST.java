package com.example.leetcode.sep17;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode tree = sortedArrayToBST.sortedArrayToBST(array);
        System.out.println(tree);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length-1);
    }

    private TreeNode convertToBST(int[] nums, int start, int end) {
        TreeNode node = null;
        if (start <= end) {
            int mid = (start + end) / 2;
            node = new TreeNode(nums[mid]);
            node.left = convertToBST(nums, start, mid - 1);
            node.right = convertToBST(nums, mid+1, end);
            return node;
        }
        return node;
    }

}
