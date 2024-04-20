package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * <p>
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 * <p>
 * Leetcode link : https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 */
public class MaximumLevelSumOfABinaryTree {

    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        treeNodeDeque.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int currentLevel = 1;
        int resultLevel = 1;
        while (!treeNodeDeque.isEmpty()) {
            int sum = 0;
            for (int i = treeNodeDeque.size(); i > -0; i--) {
                TreeNode current = treeNodeDeque.remove();
                sum += current.val;
                if (current.left != null) {
                    treeNodeDeque.offer(current.left);
                }
                if (current.right != null) {
                    treeNodeDeque.offer(current.right);
                }

            }
            if (sum > maxSum) {
                maxSum = sum;
                resultLevel = currentLevel;
            }
            currentLevel++;
        }
        return resultLevel;
    }
}
