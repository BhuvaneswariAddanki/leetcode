package com.example.leetcode.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> response = new ArrayList<>();
        postorder(root, response);
        return response;

    }

    private void postorder(TreeNode node, List<Integer> response) {
        if (node != null) {
            postorder(node.left, response);
            postorder(node.right, response);
            response.add(node.val);
        }
    }

    public List<Integer> postorderTraversalUsingStack(TreeNode root) {

        List<Integer> response = new ArrayList<>();
        TreeNode currentNode = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode lastVisitedNode = null;
        while (currentNode != null || !nodeStack.isEmpty()) {
            if (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode peekNode = nodeStack.peek();
                if (peekNode.right != null && lastVisitedNode != peekNode.right) {
                    currentNode = peekNode.right;
                } else {
                    response.add(peekNode.val);
                    lastVisitedNode = nodeStack.pop();

                }
            }
        }
        return response;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();      // a LinkedList to return the output
        Stack<TreeNode> stack = new Stack<>();              // a Stack to store nodes while traversing
        if (root != null) {
            stack.add(root);                    // add the root node to the stack
        }
        while (!stack.isEmpty()) {              // iterate the while loop until the stack is empty
            TreeNode node = stack.pop();        // pop the top node from the stack
            list.addFirst(node.val);            // add current node value to the list
            if (node.left != null) {
                stack.add(node.left);           // push left child to stack if it is not null
            }
            if (node.right != null) {
                stack.add(node.right);          // push right child to stack if it is not null
            }
        }
        return list;
    }
}
