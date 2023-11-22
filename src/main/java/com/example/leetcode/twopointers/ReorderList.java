package com.example.leetcode.twopointers;

import com.example.leetcode.ListNode;

import java.util.Stack;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            nodeStack.push(current);
            current = current.next;
        }
        int limit = nodeStack.size() % 2 == 0 ? nodeStack.size() / 2 - 1 : nodeStack.size() / 2;
        current = head;
        for (int i = 0; i <= limit; i++) {
            ListNode temp = current.next;
            ListNode top = nodeStack.pop();
            current.next = top;
            top.next = temp;
            current = temp;
        }
        current.next.next = null;


    }
}
