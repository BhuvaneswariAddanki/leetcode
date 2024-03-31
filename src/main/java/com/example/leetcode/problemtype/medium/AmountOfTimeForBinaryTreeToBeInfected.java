package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 * <p>
 * Each minute, a node becomes infected if:
 * <p>
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * <p>
 * Return the number of minutes needed for the entire tree to be infected.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 * Explanation: The following nodes are infected during:
 * - Minute 0: Node 3
 * - Minute 1: Nodes 1, 10 and 6
 * - Minute 2: Node 5
 * - Minute 3: Node 4
 * - Minute 4: Nodes 9 and 2
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1], start = 1
 * Output: 0
 * Explanation: At minute 0, the only node in the tree is infected so we return 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 105
 * Each node has a unique value.
 * A node with a value of start exists in the tree.
 * <p>
 * Leetcode link : https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 */
public class AmountOfTimeForBinaryTreeToBeInfected {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public static int maxLength(TreeNode node) {
        int lc = node.left == null ? 0 : maxLength(node.left) + 1;
        int rc = node.right == null ? 0 : maxLength(node.right) + 1;
        return Math.max(lc, rc);
    }

    static int times = 0;

    public static int countToStart(TreeNode node, int startVal) {
        if (node.val == startVal) {
            times = maxLength(node);
            return -1;
        }

        if (node.left == null && node.right == null)
            return 1;

        int lc = node.left == null ? 0 : countToStart(node.left, startVal);
        int rc = node.right == null ? 0 : countToStart(node.right, startVal);
        if (lc < 0) {
            times = Math.max(times, rc - lc);
            return lc - 1;
        } else if (rc < 0) {
            times = Math.max(times, lc - rc);
            return rc - 1;
        } else
            return Math.max(lc, rc) + 1;
    }

    public int amountOfTimeUsingLength(TreeNode root, int start) {
        countToStart(root, start);
        return times;
    }

    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, List<Integer>> adjacentNodes = getIntegerListMap(root);
        Map<Integer, Integer> infectedTimeMap = new HashMap<>();
        calculateInfectionTime(adjacentNodes, infectedTimeMap, start, 0);
        int maxTime = 0;
        for (Map.Entry<Integer, Integer> timeEntry : infectedTimeMap.entrySet()) {
            maxTime = Math.max(maxTime, timeEntry.getValue());
        }
        return maxTime;

    }

    private Map<Integer, List<Integer>> getIntegerListMap(TreeNode root) {
        Map<Integer, List<Integer>> adjacentNodes = new HashMap<>();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.offer(root);
        while (!nodeDeque.isEmpty()) {
            for (int i = nodeDeque.size(); i > 0; i--) {
                TreeNode current = nodeDeque.remove();
                adjacentNodes.putIfAbsent(current.val, new ArrayList<>());
                addNodeToAdjacentList(adjacentNodes, nodeDeque, current, current.left);
                addNodeToAdjacentList(adjacentNodes, nodeDeque, current, current.right);
            }
        }
        return adjacentNodes;
    }


    private void calculateInfectionTime(Map<Integer, List<Integer>> adjacentNodes, Map<Integer, Integer> infectedTimeMap, int start, int time) {

        List<Integer> adjacentNodesList = adjacentNodes.get(start);
        infectedTimeMap.put(start, time);
        for (Integer neighbour : adjacentNodesList) {
            if (!infectedTimeMap.containsKey(neighbour)) {
                calculateInfectionTime(adjacentNodes, infectedTimeMap, neighbour, time + 1);
            }
        }

    }

    private void addNodeToAdjacentList(Map<Integer, List<Integer>> adjacentNodes, Deque<TreeNode> nodeDeque, TreeNode current, TreeNode child) {
        if (child != null) {
            adjacentNodes.get(current.val).add(child.val);
            adjacentNodes.putIfAbsent(child.val, new ArrayList<>());
            adjacentNodes.get(child.val).add(current.val);
            nodeDeque.offer(child);
        }
    }
}
