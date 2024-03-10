package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * <p>
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * leetcode link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length - 1);
    }

    private TreeNode convertToBST(int[] nums, int start, int end) {
        if (start <= end && end < nums.length) {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = convertToBST(nums, start, mid - 1);
            node.right = convertToBST(nums, mid + 1, end);
            return node;
        }
        return null;
    }
}
