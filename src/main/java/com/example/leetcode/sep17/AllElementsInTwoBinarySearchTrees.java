package com.example.leetcode.sep17;

import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
public class AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nodesList1 = inorderTraversal(root1);
        List<Integer> nodesList2 = inorderTraversal(root2);
        sortAndAppendLists(nodesList1, nodesList2);
        return nodesList1;
    }

    private void sortAndAppendLists(List<Integer> nodesList1, List<Integer> nodesList2) {
        int index2 = 0, index1 = 0;
        while (index2 < nodesList2.size() && index1 < nodesList1.size()) {
            if (nodesList1.get(index1) > nodesList2.get(index2)) {
                nodesList1.add(index1, nodesList2.get(index2));
                index1++;
                index2++;
            } else {
                index1++;
            }
        }
        while ((index2 < nodesList2.size())){
            nodesList1.add(nodesList2.get(index2++));
        }
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> nodeList = new ArrayList<>();
        TreeNode current = root;
        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            nodeList.add(current.val);
            current = current.right;
        }
        return nodeList;
    }

    private List<Integer> sortListsBasic(List<Integer> nodesList1, List<Integer> nodesList2) {
        int l1 = 0, l2 = 0;
        List<Integer> temp = new ArrayList<>();
        while (l1 <= nodesList1.size() - 1 && l2 <= nodesList2.size() - 1) {
            if (nodesList1.get(l1) < nodesList2.get(l2)) {
                temp.add(nodesList1.get(l1));
                l1++;
            } else {
                temp.add(nodesList2.get(l2));
                l2++;
            }
        }
        while (l1 <= nodesList1.size() - 1) {
            temp.add(nodesList1.get(l1));
            l1++;
        }
        while (l2 <= nodesList2.size() - 1) {
            temp.add(nodesList2.get(l2));
            l2++;
        }
        return temp;
    }
}
