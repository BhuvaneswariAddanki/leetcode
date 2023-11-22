package com.example.leetcode.twopointers;

import com.example.leetcode.ListNode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2,
                new ListNode(2, new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(5))))))))));
        RemoveDuplicatesFromSortedList object = new RemoveDuplicatesFromSortedList();
        listNode = object.deleteDuplicates(listNode);
        System.out.print(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode current = head.next;
        while (current != null) {
            if (prev.val != current.val) {
                prev.next = current;
                prev = current;
            }
            current = current.next;
        }
        prev.next = null;
        return head;
    }
}
