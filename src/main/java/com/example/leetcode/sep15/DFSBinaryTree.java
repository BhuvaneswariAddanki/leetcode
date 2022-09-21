package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(8),
                                new TreeNode(9,
                                        new TreeNode(10,
                                                null,
                                                new TreeNode(11)),
                                        null))),
                new TreeNode(3,
                        new TreeNode(6,
                                null,
                                new TreeNode(14))
                        , new TreeNode(7,
                        null,
                        new TreeNode(12,
                                new TreeNode(13,
                                        null,
                                        new TreeNode(15)),
                                null))));

        DFSBinaryTree dfsBinaryTree = new DFSBinaryTree();
        List<Integer> result = dfsBinaryTree.dfs(root);
        System.out.println(result);
        result = dfsBinaryTree.dfsRecursive(root);
        System.out.println(result);

    }


    public List<Integer> dfs(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();
            result.add(current.val);
            if (current.right != null) {
                nodeStack.push(current.right);
            }
            if (current.left != null) {
                nodeStack.push(current.left);
            }
        }
        return result;
    }

    public List<Integer> dfsRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            recursive(node.left, result);
            recursive(node.right, result);
        }

    }
}
