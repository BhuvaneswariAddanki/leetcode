package com.example.leetcode.twopointers;

import com.example.leetcode.ListNode;

public class RotateList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        RotateList rotateList = new RotateList();
        ListNode result = rotateList.rotateRight(listNode, 7);
        System.out.print(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode fast = head;
        int count = 1;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        fast.next = head;
        k = k % count;
        int parentPos = count - k - 1;
        ListNode current = head;
        for (int i = 0; i < parentPos; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;

        return head;
    }


    public ListNode rotateRightForSingleRound(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null && count < k) {
            fast = fast.next;
            count++;
        }
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode main = slow.next;
        slow.next = null;
        fast.next = head;
        return main;
    }
}
