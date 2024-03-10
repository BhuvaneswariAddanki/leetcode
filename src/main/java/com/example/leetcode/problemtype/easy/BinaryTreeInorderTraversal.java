package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
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
 * Leetcode link : https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversalRecursive(TreeNode root) {

        List<Integer> response = new ArrayList<>();

        if (root != null) {
            recursive(root, response);
        }
        return response;
    }

    private void recursive(TreeNode node, List<Integer> response) {
        if (node.left != null)
            recursive(node.left, response);
        response.add(node.val);
        if (node.right != null)
            recursive(node.right, response);


    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorderList = new ArrayList<>();
        TreeNode currentNode = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (currentNode != null || !nodeStack.isEmpty()) {
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = nodeStack.pop();
            inorderList.add(currentNode.val);
            currentNode = currentNode.right;

        }


        return inorderList;

    }

}
