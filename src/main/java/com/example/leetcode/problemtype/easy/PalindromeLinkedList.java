package com.example.leetcode.problemtype.easy;

import com.example.leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 * or false otherwise.
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * Follow up: Could you do it in O(n) time and O(1) space?
 * <p>
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Deque<ListNode> listNodeDeque = new ArrayDeque<>();
        ListNode current = head;
        while (current != null) {
            listNodeDeque.push(current);
            current = current.next;
        }
        current = head;
        while (!listNodeDeque.isEmpty() && current != null) {
            if (current.val != listNodeDeque.pop().val) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

}
