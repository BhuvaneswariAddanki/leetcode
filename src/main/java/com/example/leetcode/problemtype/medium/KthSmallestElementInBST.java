package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * <p>
 * <p>
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 */
public class KthSmallestElementInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4));
        KthSmallestElementInBST obj = new KthSmallestElementInBST();
        int val = obj.kthSmallest(root, 1);
        System.out.println(val);
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        TreeNode current = root;
        int count = 0;
        while (current != null || !treeNodeDeque.isEmpty()) {

            while (current != null) {
                treeNodeDeque.push(current);
                current = current.left;
            }
            current = treeNodeDeque.pop();
            count = count + 1;
            if (count == k) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }
}
