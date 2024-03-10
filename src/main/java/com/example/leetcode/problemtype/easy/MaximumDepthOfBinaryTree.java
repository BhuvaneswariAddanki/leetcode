package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        int depth = 0;

        while (!treeNodeQueue.isEmpty()) {
            int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode current = treeNodeQueue.remove();
                if (current.left != null) {
                    treeNodeQueue.offer(current.left);
                }
                if (current.right != null) {
                    treeNodeQueue.offer(current.right);
                }

            }
            depth++;
        }
        return depth;
    }

    public int maxDepthRecursive(TreeNode root) {

        return findMax(root);

    }

    private int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(findMax(node.left), findMax(node.right));
    }
}
