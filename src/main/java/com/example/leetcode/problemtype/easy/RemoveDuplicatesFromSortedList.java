package com.example.leetcode.problemtype.easy;

import com.example.leetcode.ListNode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,1,2]
 * Output: [1,2]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedList {

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
