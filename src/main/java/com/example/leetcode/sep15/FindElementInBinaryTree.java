package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;

public class FindElementInBinaryTree {
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

        FindElementInBinaryTree object = new FindElementInBinaryTree();
        System.out.println("ele 14: " + object.findElement(root, 14));
        System.out.println("ele 9: " + object.findElement(root, 9));
        System.out.println("ele 89: " + object.findElement(root, 89));
        System.out.println("ele 8: " + object.findElement(root, 8));
        System.out.println("ele 45: " + object.findElement(root, 45));

    }

    public boolean elementExistsInTree(TreeNode root, int element) {
        return findElement(root, element);
    }

    private boolean findElement(TreeNode node, int element) {
        if (node != null) {
            if (node.val == element) {
                return true;
            }
            return findElement(node.left, element) || findElement(node.right, element);

        }
        return false;
    }
}
