package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 * <p>
 * <p>
 * Leetcode link : https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(listNode);
        System.out.println(listNode);
    }

    public void reorderList(ListNode head) {

        //1.find Middle element
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2. Reverse the second half of the linked list
        ListNode current = slow;
        ListNode prev = null;
        while (current != null) {
            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }

        //3. Merge fist half and reversed 2nd half of linked list
        ListNode first = head;
        ListNode second = prev;
        while (first != slow && second != null) {
            ListNode tempNextFirst = first.next;
            ListNode tempNextSecond = second.next;
            first.next = second;
            second.next = tempNextFirst;
            first = tempNextFirst;
            second = tempNextSecond;
        }

        if (first != null && first.next != null) {
            first.next.next = null;
        }


    }

    public void reorderListUSingExtraMEmory(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            nodeStack.push(current);
            current = current.next;
        }
        int limit = nodeStack.size() % 2 == 0 ? nodeStack.size() / 2 - 1 : nodeStack.size() / 2;
        current = head;
        for (int i = 0; i <= limit; i++) {
            ListNode temp = current.next;
            ListNode top = nodeStack.pop();
            current.next = top;
            top.next = temp;
            current = temp;
        }
        current.next.next = null;
    }
}
