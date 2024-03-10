package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode lastVisitedNode = root;
        List<Integer> postOrderList = new ArrayList<>();
        while (current != null || treeNodeDeque.isEmpty()) {

            while (current != null) {
                treeNodeDeque.push(current);
                current = current.left;
            }
            TreeNode peekNode = treeNodeDeque.peek();
            if (peekNode.right != null && lastVisitedNode != peekNode.right) {
                current = peekNode.right;

            } else {
                postOrderList.add(peekNode.val);
                lastVisitedNode = treeNodeDeque.pop();
            }
        }
        return postOrderList;

    }


    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.left != null) {
                recursive(node.left, result);
            }
            if (node.right != null) {
                recursive(node.right, result);
            }
            result.add(node.val);
        }
    }


}
