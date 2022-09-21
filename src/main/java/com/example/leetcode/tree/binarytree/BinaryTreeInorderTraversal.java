package com.example.leetcode.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();

        List<Integer> result = binaryTreeInorderTraversal.inorderTraversal(root);
        System.out.println(result);
        result = binaryTreeInorderTraversal.inorderTraversalRecursive(root);
        System.out.println(result);
    }

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
