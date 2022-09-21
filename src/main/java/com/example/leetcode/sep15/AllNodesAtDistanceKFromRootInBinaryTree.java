package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesAtDistanceKFromRootInBinaryTree {

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
        AllNodesAtDistanceKFromRootInBinaryTree obj = new AllNodesAtDistanceKFromRootInBinaryTree();
        List<Integer> elementAtLevelK = obj.findElementAtLevelK(root, 3);
        System.out.println("Ele at distance 3 : " + elementAtLevelK);
        System.out.println("Ele at distance 2 : " + obj.findElementAtLevelK(root, 2));
        System.out.println("Ele at distance 1 : " + obj.findElementAtLevelK(root, 1));
        System.out.println("Ele at distance 0 : " + obj.findElementAtLevelK(root, 0));
        System.out.println("Ele at distance 4 : " + obj.findElementAtLevelK(root, 4));
        System.out.println("Ele at distance 5 : " + obj.findElementAtLevelK(root, 5));
        System.out.println("Ele at distance 6 : " + obj.findElementAtLevelK(root, 6));


    }

    public List<Integer> findElementAtLevelK(TreeNode node, int distance) {
        return dfs(node, distance, 0);
    }

    private List<Integer> dfs(TreeNode node, int distance, int height) {
        List<Integer> response = new ArrayList<>();
        if (node != null & height <= distance) {
            if (distance == height) {
                response.add(node.val);
            } else {
                response.addAll(dfs(node.left, distance, height + 1));
                response.addAll(dfs(node.right, distance, height + 1));
            }
        }
        return response;
    }
}
