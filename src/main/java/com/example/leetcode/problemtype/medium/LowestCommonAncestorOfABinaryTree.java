package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Example 3:
 * <p>
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 * <p>
 * Leetcode link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        LowestCommonAncestorOfABinaryTree obj = new LowestCommonAncestorOfABinaryTree();
        TreeNode node = obj.lowestCommonAncestor(treeNode, 2, 41);
        System.out.println(node);
    }

    /**
     * p and q will exist in the tree.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findElement(root, p, q);
    }

    private TreeNode findElement(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftSubTreeNode = findElement(root.left, p, q);
        TreeNode rightSubTreeNode = findElement(root.right, p, q);
        if (leftSubTreeNode != null && rightSubTreeNode != null) {
            return root;
        } else if (leftSubTreeNode != null) {
            return leftSubTreeNode;
        } else {
            return rightSubTreeNode;
        }
    }

    /**
     * No guarantee that p and q exist in the binary tree
     * return -1/NULL if any of the given keys are not present in the tree
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        boolean[] eleFound = new boolean[2];
        TreeNode lca = findLcaElement(root, p, q, eleFound);
        return eleFound[0] && eleFound[1] ? lca : null;
    }

    private TreeNode findLcaElement(TreeNode root, int p, int q, boolean[] eleFound) {
        if (root == null) {
            return null;
        }
        TreeNode temp = null;
        if (root.val == p) {
            eleFound[0] = true;
            temp = root;
        }
        if (root.val == q) {
            eleFound[1] = true;
            temp = root;
        }
        TreeNode left = findLcaElement(root.left, p, q, eleFound);
        TreeNode right = findLcaElement(root.right, p, q, eleFound);
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
