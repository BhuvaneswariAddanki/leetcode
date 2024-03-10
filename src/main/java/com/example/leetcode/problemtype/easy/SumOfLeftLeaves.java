package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 * <p>
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: 0
 * <p>
 * Leetcode link :  https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = treeNodeQueue.remove();

                if (current.left != null) {
                    treeNodeQueue.offer(current.left);
                    if (current.left.left == null && current.left.right == null) {
                        sum += current.left.val;
                    }
                }
                if (current.right != null) {
                    treeNodeQueue.offer(current.right);
                }
            }
        }
        return sum;
    }
}
