package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Leetcode link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int deleteIndexFromRight) {

        int length = size(head);
        int parentPos = length - deleteIndexFromRight;
        if (parentPos == 0) {
            return head.next;
        }
        int index = 1;
        ListNode current = head;
        while (index < parentPos) {
            current = current.next;
            index++;
        }
        current.next = current.next.next;
        return head;
    }

    private int size(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * Maintain 2 pointers fast and slaw
     * Step 1 : move the fast pointer by n nodes
     * if fast is null, then the node we need to delete is head node -> return had.next
     * otherwise,... move slow pointer from and fast pointer one by one till fast reaches to end (fast.next == NULL)
     * then slow pointer will be parent node
     * change the next of parent to next->next
     *
     * @param head
     * @param deleteIndexFromRight
     * @return
     */
    public ListNode removeNthFromEndInSinglePass(ListNode head, int deleteIndexFromRight) {

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < deleteIndexFromRight; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
