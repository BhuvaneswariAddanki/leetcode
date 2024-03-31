package com.example.leetcode.problemtype.medium;

import com.example.leetcode.tree.binarytree.TreeNode;

/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * <p>
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The input tree is guaranteed to be a binary search tree.
 * <p>
 * Leetcode link : https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 */
public class SerializeAndDeserializeBST {

    int index;

    public String serialize(TreeNode root) {
        StringBuilder serializedTree = new StringBuilder();
        preorder(root, serializedTree);
        return serializedTree.toString();
    }

    private void preorder(TreeNode root, StringBuilder serializedTree) {
        if (root != null) {
            serializedTree.append(root.val).append(",");
            preorder(root.left, serializedTree);
            preorder(root.right, serializedTree);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String serializedTree) {
        String[] nodes = serializedTree.split(",");
        index = 0;
        return buildTree(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(String[] nodes, int min, int max) {
        if (index >= nodes.length) {
            return null;
        }
        Integer val = parseStringToInt(nodes[index++]);
        if (val == null || val < min || val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = buildTree(nodes, min, val);
        node.left = buildTree(nodes, val, max);
        return node;

    }

    Integer parseStringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
