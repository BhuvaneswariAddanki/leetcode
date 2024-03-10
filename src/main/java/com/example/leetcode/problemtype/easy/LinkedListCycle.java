package com.example.leetcode.problemtype.easy;

import com.example.leetcode.ListNode;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * leetcode link : https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (first != second && first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first == second;
    }
}
