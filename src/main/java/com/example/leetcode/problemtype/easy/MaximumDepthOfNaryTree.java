package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.NTreeNode;
import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The total number of nodes is in the range [0, 104].
 * The depth of the n-ary tree is less than or equal to 1000.
 * <p>
 * Leetcode link : https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
 */
public class MaximumDepthOfNaryTree {

    public int maxDepth(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NTreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        int depth = 0;

        while (!treeNodeQueue.isEmpty()) {
            int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                NTreeNode current = treeNodeQueue.remove();
                if (null != current.children) {
                    for (NTreeNode child : current.children) {
                        treeNodeQueue.offer(child);
                    }
                }
            }
            depth++;
        }

        return depth;
    }

    public int maxDepthUsingDfs(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public int dfs(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (NTreeNode i : root.children) {
            maxDepth = Math.max(maxDepth, dfs(i));
        }
        return 1 + maxDepth;
    }
}
