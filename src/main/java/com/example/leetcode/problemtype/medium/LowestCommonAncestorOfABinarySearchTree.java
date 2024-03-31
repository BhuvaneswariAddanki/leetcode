package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Example 3:
 * <p>
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 * <p>
 * Leetcode link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        LowestCommonAncestorOfABinarySearchTree obj = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode node = obj.lowestCommonAncestor(treeNode, 2, 8);
        System.out.println(node);
    }

    public TreeNode lowestCommonAncestorUsingRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

        if (root == null) {
            return null;
        }
        boolean[] eleFound = new boolean[2];
        int min = Math.min(p, q);
        int max = Math.max(p, q);
        TreeNode lca = lca(root, min, max, eleFound);

        return eleFound[0] && eleFound[1] ? lca : null;

    }

    public TreeNode lca(TreeNode root, int min, int max, boolean[] eleFound) {

        if (root == null) {
            return null;
        }
        TreeNode temp = null;
        if (root.val == min) {
            eleFound[0] = true;
            temp = root;
        }
        if (root.val == max) {
            eleFound[1] = true;
            temp = root;
        }

        TreeNode left = null;
        TreeNode right = null;
        if (!eleFound[0] || !eleFound[1]) {
            if (min < root.val && max > root.val) {
                left = lca(root.left, min, max, eleFound);
                right = lca(root.right, min, max, eleFound);
            } else if (min > root.val || max > root.val) {
                right = lca(root.right, min, max, eleFound);
            } else {
                left = lca(root.left, min, max, eleFound);
            }
        }

        if (temp != null) {
            return temp;
        }
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }

    }


}

