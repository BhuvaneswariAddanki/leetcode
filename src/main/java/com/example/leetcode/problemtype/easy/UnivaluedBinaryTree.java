package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * A binary tree is uni-valued if every node in the tree has the same value.
 * <p>
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 * <p>
 * Input: root = [1,1,1,1,1,null,1]
 * Output: true
 * <p>
 * Input: root = [2,2,2,5,2]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 100].
 * 0 <= Node.val < 100
 * Leetcode link : https://leetcode.com/problems/univalued-binary-tree/description/
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return checkValue(root, root.val);
        }
    }

    private boolean checkValue(TreeNode node, int val) {

        if (node != null) {
            if (node.val == val) {
                return checkValue(node.left, val) && checkValue(node.right, val);
            }
            return false;
        }
        return true;
    }

    public boolean isUnivalTreeIteration(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int val = root.val;

            Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
            treeNodeQueue.offer(root);
            while (!treeNodeQueue.isEmpty()) {
                for (int i = treeNodeQueue.size(); i > 0; i--) {
                    TreeNode current = treeNodeQueue.remove();
                    if (current.val == val) {
                        if (current.left != null) {
                            treeNodeQueue.offer(current.left);
                        }
                        if (current.right != null) {
                            treeNodeQueue.offer(current.right);
                        }
                    } else {
                        return false;
                    }
                }

            }
            return true;
        }
    }


}
