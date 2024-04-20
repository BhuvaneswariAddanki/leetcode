package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 * Example 1:
 * <p>
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 * Constraints:
 * <p>
 * The number of nodes in each tree is in the range [0, 5000].
 * -105 <= Node.val <= 105
 * Leetcode link : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
 */
public class AllElementsInTwoBinarySearchTrees {
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
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> nodesList1 = inorderTraversal(root1);
            List<Integer> nodesList2 = inorderTraversal(root2);
            sortAndAppendLists(nodesList1, nodesList2);
            return nodesList1;
        }

        private void sortAndAppendLists(List<Integer> nodesList1, List<Integer> nodesList2) {
            int index2 = 0;
            int index1 = 0;
            while (index2 < nodesList2.size() && index1 < nodesList1.size()) {
                if (nodesList1.get(index1) > nodesList2.get(index2)) {
                    nodesList1.add(index1, nodesList2.get(index2));
                    index1++;
                    index2++;
                } else {
                    index1++;
                }
            }
            while ((index2 < nodesList2.size())) {
                nodesList1.add(nodesList2.get(index2++));
            }

        }

        private List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> nodeStack = new Stack<>();
            List<Integer> nodeList = new ArrayList<>();
            TreeNode current = root;
            while (current != null || !nodeStack.isEmpty()) {
                while (current != null) {
                    nodeStack.push(current);
                    current = current.left;
                }
                current = nodeStack.pop();
                nodeList.add(current.val);
                current = current.right;
            }
            return nodeList;
        }
    }
}
