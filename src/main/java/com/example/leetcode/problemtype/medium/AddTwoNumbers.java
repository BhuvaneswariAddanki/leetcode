package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in each linked list is in the range [1, 100].
 *     0 <= Node.val <= 9
 *     It is guaranteed that the list represents a number that does not have leading zeros.
 *
 * Leetcode link : https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode response = new ListNode(0);
        ListNode result = response;
        int carryForward = 0;

        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carryForward;
            ListNode newNode = new ListNode(sum % 10);
            carryForward = sum / 10;
            result.next = newNode;
            result = result.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            int sum = carryForward + head1.val;
            ListNode newNode = new ListNode(sum % 10);
            carryForward = sum / 10 ;
            result.next = newNode;
            result = result.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            int sum = carryForward + head2.val;
            ListNode newNode = new ListNode(sum % 10);
            carryForward = sum / 10 ;
            result.next = newNode;
            result = result.next;
            head2 = head2.next;
        }
        if( carryForward != 0){
            result.next = new ListNode(carryForward);
        }
        return  response.next;
    }
}
