package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * <p>
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 * <p>
 * Leetcode link : https://leetcode.com/problems/house-robber-iii/description/
 */
public class HouseRobberIII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        int amount = houseRobberIII.rob(root);
        System.out.println(amount);
    }


    public int rob(TreeNode root) {
        int[] results = robSubtree(root);
        // The maximum of robbing current node and not robbing the current node
        return Math.max(results[0], results[1]);
    }

    private int[] robSubtree(TreeNode node) {
        if (node == null) {
            // Base case: If the current node is null, return 0 for both cases.
            return new int[2];
        }
        int[] leftResults = robSubtree(node.left);
        int[] rightResults = robSubtree(node.right);

        // Robbing the current node
        int robNode = node.val + leftResults[1] + rightResults[1];
        // Not robbing the current node (taking the max of robbing or not robbing
        // children)
        int notRobNode = Math.max(leftResults[0], leftResults[1]) + Math.max(rightResults[0], rightResults[1]);

        return new int[]{robNode, notRobNode};
    }

    public int rob2(TreeNode root) {
        int[] result = findAmount(root);
        return Math.max(result[0], result[1]);
    }

    private int[] findAmount(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] robLeft = findAmount(root.left);
        int[] robRight = findAmount(root.right);

        int robHouse = root.val + robLeft[1] + robRight[1];
        int notRobHouse = Math.max(robLeft[1], robLeft[0]) +
                Math.max(robRight[1], robRight[0]);

        return new int[]{robHouse, notRobHouse};
    }
}
