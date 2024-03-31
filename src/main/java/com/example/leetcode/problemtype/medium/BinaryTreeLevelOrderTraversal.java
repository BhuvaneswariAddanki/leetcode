package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * <p>
 * Leetcode link : https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        treeNodeDeque.offer(root);
        while (!treeNodeDeque.isEmpty()) {
            List<Integer> nodesAtOneLevel = new ArrayList<>();
            for (int i = treeNodeDeque.size(); i > 0; i--) {
                TreeNode treeNode = treeNodeDeque.remove();
                nodesAtOneLevel.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeDeque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeDeque.offer(treeNode.right);
                }
            }
            result.add(nodesAtOneLevel);
        }
        return result;
    }
}
