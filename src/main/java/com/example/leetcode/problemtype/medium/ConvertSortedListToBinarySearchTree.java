package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;
import com.example.leetcode.tree.binarytree.TreeNode;

import java.util.List;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced
 * binary search tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * <p>
 * Example 2:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in head is in the range [0, 2 * 104].
 * -105 <= Node.val <= 105
 * <p>
 * Leetcode link : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(-10,new ListNode(-3,new ListNode(0, new ListNode(5,new ListNode(9)))));
        ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();
       TreeNode result =  obj.sortedListToBST(listNode);
       System.out.println(result);
    }
    public TreeNode sortedListToBST(ListNode head) {
        return convertListToBST(head, null);
    }

    private TreeNode convertListToBST(ListNode head, ListNode end) {
        if (head == null || head == end) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = convertListToBST(head, slow);
        treeNode.right = convertListToBST(slow.next, end);
        return treeNode;

    }


}
