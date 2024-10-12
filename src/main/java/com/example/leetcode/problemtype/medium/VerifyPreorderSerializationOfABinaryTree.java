package com.example.leetcode.problemtype.medium;

/**
 * One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.
 * <p>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
 * <p>
 * Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
 * <p>
 * It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid.
 * <p>
 * For example, it could never contain two consecutive commas, such as "1,,3".
 * <p>
 * Note: You are not allowed to reconstruct the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: preorder = "1,#"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: preorder = "9,#,#,1"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 104
 * preorder consist of integers in the range [0, 100] and '#' separated by commas ','.
 * <p>
 * Leetcode link : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 */
public class VerifyPreorderSerializationOfABinaryTree {

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String preorder1 = "1,#";
        String preorder2 = "9,#,#,1";
        VerifyPreorderSerializationOfABinaryTree obj = new VerifyPreorderSerializationOfABinaryTree();
        boolean result = obj.isValidSerialization(preorder);
        boolean result1 = obj.isValidSerialization(preorder1);
        boolean result2 = obj.isValidSerialization(preorder2);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);

    }


    int index = 0;

    public boolean isValidSerialization(String preorder) {
        String[] order = preorder.split(",");
        boolean valid = verify(order);
        return index == order.length - 1 && valid;
    }

    private boolean verify(String[] order) {
        if (index >= order.length) {
            return false;
        }
        if ("#".equalsIgnoreCase(order[index])) {
            return true;
        }
        index = index + 1;
        boolean left = verify(order);
        index = index + 1;
        boolean right = verify(order);
        return left && right;
    }

    public boolean isValidSerializationUsingCount(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;

    }

}
