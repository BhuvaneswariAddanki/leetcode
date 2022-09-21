package com.example.leetcode.sep18;

import com.example.leetcode.ListNode;
import com.example.leetcode.tree.binarytree.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return convertListToBST(head, null);
    }

    private TreeNode convertListToBST(ListNode head, ListNode end) {
        if (head == null || end == head) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = convertListToBST(head, slow);
        node.right = convertListToBST(slow.next, end);
        return node;
    }
}
