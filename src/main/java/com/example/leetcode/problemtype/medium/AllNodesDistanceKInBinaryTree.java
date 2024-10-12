package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1], target = 1, k = 3
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 * <p>
 * Leetcode link : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * <p>
 * geeksForGeeks :: https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */
public class AllNodesDistanceKInBinaryTree {


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        findPath(root, target, path);
        for (int i = 0; i < path.size(); i++) {
            printKDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1), ans);
        }
        return ans;
    }

    public void printKDown(TreeNode node, int k, TreeNode blocker, List<Integer> ans) {
        if (node == null || node == blocker) return;
        if (k == 0) {
            ans.add(node.val);
        } else {
            printKDown(node.left, k - 1, blocker, ans);
            printKDown(node.right, k - 1, blocker, ans);
        }
    }


    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        if (root == target) {
            path.add(root);
            return true;
        }
        boolean foundLeft = findPath(root.left, target, path);
        if (foundLeft) {
            path.add(root);
            return true;
        }

        boolean foundRight = findPath(root.right, target, path);
        if (foundRight) {
            path.add(root);
            return true;
        }
        return false;
    }


    List<Integer> response = new ArrayList<>();

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k);
        return response;
    }

    private int dfs(TreeNode root, TreeNode target, int k) {
        if (root != null) {
            if (root.val == target.val) {
                NodesAtKDistance(root, k, 0);
                return 1;
            } else {
                int foundInLeft = dfs(root.left, target, k);
                int foundInRight = dfs(root.right, target, k);
                if (findNodesInOtherSubTree(root, k, foundInLeft, root.right)) {
                    return foundInLeft + 1;
                }
                if (findNodesInOtherSubTree(root, k, foundInRight, root.left)) {
                    return foundInRight + 1;
                }
            }

        }
        return -1;
    }

    private boolean findNodesInOtherSubTree(TreeNode root, int k, int foundLevel, TreeNode subTree) {
        if (foundLevel != -1) {
            if (foundLevel == k) {
                response.add(root.val);
            }
            NodesAtKDistance(subTree, k, foundLevel + 1);
            return true;
        }
        return false;
    }

    private void NodesAtKDistance(TreeNode root, int k, int level) {
        if (root != null && level <= k) {
            if (level == k) {
                response.add(root.val);
            } else {
                NodesAtKDistance(root.left, k, level + 1);
                NodesAtKDistance(root.right, k, level + 1);
            }
        }
    }

}
