package com.example.leetcode.sep17;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
 * <p>
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 * <p>
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 */
public class BalanceBinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedElements = inorderTraversal(root);
        return getBalancedBST(sortedElements);

    }

    private TreeNode getBalancedBST(List<Integer> sortedElements) {
        return constructBBST(sortedElements, 0, sortedElements.size() - 1);
    }

    private TreeNode constructBBST(List<Integer> sortedElements, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(sortedElements.get(mid));
            node.left = constructBBST(sortedElements, start, mid - 1);
            node.right = constructBBST(sortedElements, mid + 1, end);
            return node;
        }
        return null;
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
