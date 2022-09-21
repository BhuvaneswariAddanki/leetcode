package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;


import java.util.*;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 */

public class AllNodesDistanceKinBinaryTree {

    AllNodesAtDistanceKFromRootInBinaryTree obj = new AllNodesAtDistanceKFromRootInBinaryTree();

    public static void main(String[] args) {
        TreeNode targetNode = new TreeNode(5,
                new TreeNode(8),
                new TreeNode(9,
                        new TreeNode(10,
                                null,
                                new TreeNode(11)),
                        null));
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        targetNode),
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

        AllNodesDistanceKinBinaryTree object = new AllNodesDistanceKinBinaryTree();
        List<Integer> response = object.distanceK(root, targetNode, 2);
        System.out.println(response);

    }

    List<Integer> response = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k);
        return response;

    }

    public int dfs(TreeNode node, TreeNode target, int k) {
        if (node != null) {
            if (node == target) {
                subtreeNodes(node, k, 0);
                return 1;
            } else {
                int l = dfs(node.left, target, k);
                int r = dfs(node.right, target, k);
                if (l != -1) {
                    if (l == k) {
                        response.add(node.val);
                    }
                    subtreeNodes(node.right, k, l + 1);
                    return l + 1;

                } else if (r != -1) {
                    if (r == k) {
                        response.add(node.val);
                    }
                    subtreeNodes(node.left, k, r + 1);
                    return r + 1;
                }
            }
        }

        return -1;
    }

    private void subtreeNodes(TreeNode node, int distance, int height) {

        if (node != null && height <= distance) {
            if (distance == height) {
                response.add(node.val);
            } else {
                subtreeNodes(node.left, distance, height + 1);
                subtreeNodes(node.right, distance, height + 1);
            }
        }
    }

}


