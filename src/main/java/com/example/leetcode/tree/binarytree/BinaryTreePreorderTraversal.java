package com.example.leetcode.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();

        List<Integer> result = binaryTreePreorderTraversal.preorderTraversal(root);
        System.out.println(result);
        result = binaryTreePreorderTraversal.preorderTraversalUsingStack(root);
        System.out.println(result);
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> response = new ArrayList<>();
        recursive(root, response);
        return response;
    }

    private void recursive(TreeNode node, List<Integer> response) {
        if(node!=null){
            response.add(node.val);
            recursive(node.left, response);
            recursive(node.right, response);
        }
    }

    public List<Integer> preorderTraversalUsingStack(TreeNode node) {

        List<Integer> preOrderList = new ArrayList<>();
        TreeNode currentNode = node;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (currentNode != null || !nodeStack.isEmpty()) {
            while (currentNode != null) {
                nodeStack.push(currentNode);
                preOrderList.add(currentNode.val);
                currentNode = currentNode.left;
            }
            currentNode = nodeStack.pop();
            currentNode = currentNode.right;

        }
        return preOrderList;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();             // an ArrayList to return the output
        Stack<TreeNode> stack = new Stack<>();              // a Stack to store nodes while traversing
        if (root != null) {
            stack.add(root);                    // add the root node to the stack
        }
        while (!stack.isEmpty()) {              // iterate the while loop until the stack is empty
            TreeNode node = stack.pop();        // pop the top node from the stack
            list.add(node.val);                 // add current node value to the list
            if (node.right != null) {
                stack.add(node.right);          // push right child to stack if it is not null
            }
            if (node.left != null) {
                stack.add(node.left);           // push left child to stack if it is not null
            }
        }
        return list;
    }
}
