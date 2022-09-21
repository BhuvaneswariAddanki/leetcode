package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(8),
                                new TreeNode(9,
                                        new TreeNode(10,
                                                null,
                                                new TreeNode(11)),
                                        null))),
                new TreeNode(3,
                        new TreeNode(6,
                                null,
                                new TreeNode(14))
                        , new TreeNode(7,
                        null,
                        new TreeNode(12,
                                new TreeNode(13,
                                        null,
                                        new TreeNode(15)),
                                null))));
        LowestCommonAncestor object = new LowestCommonAncestor();
       // object.findLowestCommonAncestor(root,4,9)
    }

    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return findEle(root, p, q);

    }

    private TreeNode findEle(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node.val == p.val || node.val == q.val) {
            return node;
        }
        TreeNode nodeLeft = findEle(node.left, p, q);
        TreeNode nodeRight = findEle(node.right, p, q);
        if (nodeLeft != null && nodeRight != null) {
            return node;
        } else if (nodeLeft != null) {
            return nodeLeft;
        } else {
            return nodeRight;
        }
    }
}
