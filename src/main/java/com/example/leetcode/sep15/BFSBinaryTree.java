package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.*;

public class BFSBinaryTree {
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

        BFSBinaryTree bfsBinaryTree = new BFSBinaryTree();
        List<Integer> result = bfsBinaryTree.bfs(root);
        System.out.println(result);

    }


    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            result.add(current.val);
            if (current.left != null) {
                nodeQueue.offer(current.left);
            }
            if (current.right != null) {
                nodeQueue.offer(current.right);
            }
        }
        return result;
    }


}
