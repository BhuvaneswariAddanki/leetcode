package com.example.leetcode.sep18;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.LinkedList;

public class SmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
        SmallestElementInBST object = new SmallestElementInBST();
        int kthsmallest = object.kthSmallest(root,20);
        System.out.println("smallest value:" + kthsmallest);

    }

    int n = 0;

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    private int findSmallest(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }
}
