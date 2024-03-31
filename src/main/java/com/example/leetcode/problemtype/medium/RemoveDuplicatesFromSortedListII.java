package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * <p>
 * Leetcode link : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {

        ListNode test = new ListNode(1, new ListNode(2,
                new ListNode(3,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(4,
                                                new ListNode(5)))))));
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));

        RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();
        ListNode result = obj.deleteDuplicates(head);
        System.out.println(result);
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode prevParent = null;
        ListNode current = head.next;
        while (current != null) {
            if (prev.val == current.val) {
                while (current != null && prev.val == current.val) {
                    current = current.next;
                }
                if (prevParent == null) {
                    head = current;
                } else {
                    prevParent.next = current;
                }
                prev = current;
            } else {
                prevParent = prev;
                prev = prev.next;
            }
            if (current != null) {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = new ListNode(0,head);
        ListNode dummy = prev;
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
