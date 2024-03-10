package com.example.leetcode.problemtype.easy;

import com.example.leetcode.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * leetcode link : https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = prev;
            prev = current;
            current = tmpNext;
        }
        return prev;
    }
}
