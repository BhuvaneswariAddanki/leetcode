package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 * <p>
 * Leetcode link : https://leetcode.com/problems/subtree-of-another-tree/description/
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) return false;
        if (match(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean match(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return match(node1.left, node2.left) && match(node1.right, node2.right);
            }
            return false;
        }
        return node1 == null && node2 == null;
    }

}
