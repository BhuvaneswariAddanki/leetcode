package com.example.leetcode.sep15;

import com.example.leetcode.tree.binarytree.TreeNode;

public class FindElementHeightInBinaryTree {
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

        FindElementHeightInBinaryTree object = new FindElementHeightInBinaryTree();
        System.out.println("ele 14: " + object.findEleHeight(root, 14));
        System.out.println("ele 9: " + object.findEleHeight(root, 9));
        System.out.println("ele 89: " + object.findEleHeight(root, 89));
        System.out.println("ele 8: " + object.findEleHeight(root, 8));
        System.out.println("ele 45: " + object.findEleHeight(root, 15));


    }

    public int findEleHeight(TreeNode root, int element) {

        return findHeight(root, element, 0);
    }

    private int findHeight(TreeNode node, int element, int height) {
        if (node != null) {
            if (node.val == element) {
                return height + 1;
            }
            int foundInLeftSubTree = findHeight(node.left, element, height + 1);
            if (foundInLeftSubTree != -1) {
                return foundInLeftSubTree;

            }
            return findHeight(node.right, element, height + 1);

        }
        return -1;
    }

}
