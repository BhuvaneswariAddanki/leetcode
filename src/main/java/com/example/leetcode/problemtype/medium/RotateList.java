package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * <p>
 * Leetcode link : https://leetcode.com/problems/rotate-list/description/
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        RotateList rotateList = new RotateList();
        ListNode result = rotateList.rotateRightFromParent(listNode, 2);
        System.out.println(result);
    }

    public ListNode rotateRightFromParent(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode fast = head;
        int count = 1;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        fast.next = head; // might produce stackoverflow for cycle
        int rotationCount = k % count;
        int parentPos = count - rotationCount - 1;
        ListNode current = head;
        for (int i = 0; i < parentPos; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;

        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        int length = length(head);
        if (length <= 1) {
            return head;
        }
        int rotationCount = (k % length);
        while (count < rotationCount) {
            fast = fast.next;
            count++;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        fast.next = head;
        slow.next = null;
        head = temp;
        return head;
    }

    private int length(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
