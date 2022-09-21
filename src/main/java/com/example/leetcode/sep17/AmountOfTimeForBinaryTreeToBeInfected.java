package com.example.leetcode.sep17;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {

    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> treeMap = buildMap(root);
        Map<Integer, Integer> infectedTime = new HashMap<>();
        infectedTime.put(start, 0);
        calculateInfectedTime(treeMap, start, infectedTime);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : infectedTime.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }

    private void calculateInfectedTime(Map<Integer, List<Integer>> treeMap, int key, Map<Integer, Integer> infectedTime) {
        for (Integer neighbour : treeMap.get(key)) {
            if (!infectedTime.containsKey(neighbour)) {
                infectedTime.put(neighbour, infectedTime.get(key) + 1);
                calculateInfectedTime(treeMap, neighbour, infectedTime);
            }
        }

    }

    private Map<Integer, List<Integer>> buildMap(TreeNode root) {

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.remove();
            map.putIfAbsent(current.val, new ArrayList<>());
            if (current.left != null) {
                map.putIfAbsent(current.left.val, new ArrayList<>());
                map.get(current.val).add(current.left.val);
                map.get(current.left.val).add(current.val);
                nodeQueue.offer(current.left);
            }
            if (current.right != null) {
                map.putIfAbsent(current.right.val, new ArrayList<>());
                map.get(current.val).add(current.right.val);
                map.get(current.right.val).add(current.val);
                nodeQueue.offer(current.right);
            }
        }
        return map;
    }
}
