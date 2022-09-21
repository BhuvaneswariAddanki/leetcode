package com.example.leetcode;

/**
 * https://leetcode.com/problems/palindrome-linked-list
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode list2 = new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(1))));
        PalindromeLinkedList obj = new PalindromeLinkedList();
        obj.isPalindrome(list2);
    }

    public boolean isPalindrome(ListNode head) {

        ListNode midEle = findMidEle(head);
        ListNode reverseSecondHalf = reverse(midEle);
        ListNode first = head;
        ListNode second = reverseSecondHalf;
        boolean isPalindrome = true;
        while (second != null) {
            if (first.val != second.val) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        return isPalindrome;
    }

    private ListNode reverse(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = prev;
            prev = current;
            current = tmpNext;
        }
        return prev;
    }

    private ListNode findMidEle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
