package com.example.leetcode.problemtype.easy;

import com.example.leetcode.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * Leetcode link : https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(-9, new ListNode(3));
        ListNode list2 = new ListNode(5, new ListNode(7));
        ListNode result = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        System.out.println(result);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        while (list1 != null) {
            current.next = list1;
            list1 = list1.next;
            current =current.next;
        }
        while (list2 != null) {
            current.next = list2;
            list2 = list2.next;
            current =current.next;
        }
        return result.next;
    }
}
