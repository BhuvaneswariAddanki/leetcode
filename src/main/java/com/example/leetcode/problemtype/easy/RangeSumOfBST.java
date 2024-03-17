package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 * <p>
 * Leetcode link : https://leetcode.com/problems/range-sum-of-bst/description/
 */
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return calculateSum(root, low, high);
    }

    private int calculateSum(TreeNode node, int low, int high) {

        if (node != null) {
            int sum;
            if (node.val < low) {
                sum = calculateSum(node.right, low, high);
            } else if (node.val > high) {
                sum = calculateSum(node.left, low, high);
            } else {
                sum = calculateSum(node.left, low, high) + calculateSum(node.right, low, high) + node.val;
            }
            return sum;
        } else {
            return 0;
        }
    }

    public int rangeSumBSTUsingQueue(TreeNode root, int low, int high) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        int result = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode current = queue.poll();
                if (current.val < low) {
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                } else if (current.val > high) {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                } else {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    result += current.val;
                }
            }

        }
        return result;
    }
}
