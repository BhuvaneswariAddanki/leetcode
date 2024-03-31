package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [[1]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 * Leetcode link : https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? null : generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubtrees = generate(start, i - 1);
                List<TreeNode> rightSubtrees = generate(i + 1, end);
                for (TreeNode leftSubTree : leftSubtrees) {
                    for (TreeNode rightSubTree : rightSubtrees) {
                        result.add(new TreeNode(i, leftSubTree, rightSubTree));
                    }
                }
            }
        }
        return result;
    }
}
