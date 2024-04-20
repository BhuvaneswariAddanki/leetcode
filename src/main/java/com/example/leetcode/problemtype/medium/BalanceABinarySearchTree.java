package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
 * <p>
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 105
 * <p>
 * Leetcode link : https://leetcode.com/problems/balance-a-binary-search-tree/description/
 */
public class BalanceABinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> sortedEle = new ArrayList<>();
        inorderTraversal(root, sortedEle);
        return constructBBST(sortedEle, 0, sortedEle.size() - 1);

    }

    private TreeNode constructBBST(List<Integer> sortedEle, int start, int end) {

        if (start <= end) {

            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(sortedEle.get(mid));
            root.left = constructBBST(sortedEle, start, mid - 1);
            root.right = constructBBST(sortedEle, mid + 1, end);
            return root;
        }
        return null;

    }

    private void inorderTraversal(TreeNode root, List<Integer> sortedEle) {
        if (root != null) {
            inorderTraversal(root.left, sortedEle);
            sortedEle.add(root.val);
            inorderTraversal(root.right, sortedEle);
        }
    }

    private List<Integer> inorderTraversalUsingIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> nodeStack = new ArrayDeque<>();
            TreeNode current = root;
            while (current != null || !nodeStack.isEmpty()) {
                while (current != null) {
                    nodeStack.push(current);
                    current = current.left;
                }
                current = nodeStack.pop();
                result.add(current.val);
                current = current.right;

            }
        }
        return result;
    }
}
