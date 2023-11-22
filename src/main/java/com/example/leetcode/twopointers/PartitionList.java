package com.example.leetcode.twopointers;

import com.example.leetcode.ListNode;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    public static void main(String[] args) {
        //head = [1,4,3,2,5,2], x = 3
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        PartitionList partitionList = new PartitionList();
        listNode = partitionList.partition(listNode,3);
       System.out.print(listNode);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyBefore = new ListNode(0);
        ListNode dummyAfter = new ListNode(0);
        ListNode list1 = dummyBefore;
        ListNode list2 = dummyAfter;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                list1.next = current;
                list1 = list1.next;
            } else {
                list2.next = current;
                list2 = list2.next;
            }
            current = current.next;
        }
        list2.next =null;
        list1.next = dummyAfter.next;
        return dummyBefore.next;
    }
}
