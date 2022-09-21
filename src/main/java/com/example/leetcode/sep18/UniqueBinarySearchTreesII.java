package com.example.leetcode.sep18;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? null : generateTreeNode(1, n);
    }

    private List<TreeNode> generateTreeNode(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = generateTreeNode(start, i - 1);
            List<TreeNode> rightSubTree = generateTreeNode(i + 1, end);
            for (TreeNode left : leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }

}
