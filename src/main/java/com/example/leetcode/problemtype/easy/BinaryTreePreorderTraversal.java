package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * <p>
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: [1]
 * Leetcode link : https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode node) {

        TreeNode current = node;
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        List<Integer> preOrderList = new ArrayList<>();
        while (current != null || !treeNodeDeque.isEmpty()) {
            while (current != null) {
                treeNodeDeque.push(current);
                preOrderList.add(current.val);
                current = current.left;
            }
            current = treeNodeDeque.pop();
            current = current.right;
        }
        return preOrderList;
    }
}
