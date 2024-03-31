package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;

/**
 * There is a singly-linked list head and we want to delete a node node in it.
 * <p>
 * You are given the node to be deleted node. You will not be given access to the first node of head.
 * <p>
 * All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
 * <p>
 * Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
 * <p>
 * The value of the given node should not exist in the linked list.
 * The number of nodes in the linked list should decrease by one.
 * All the values before node should be in the same order.
 * All the values after node should be in the same order.
 * <p>
 * Custom testing:
 * <p>
 * For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
 * We will build the linked list and pass the node to your function.
 * The output will be the entire list after calling your function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * <p>
 * Example 2:
 * <p>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the given list is in the range [2, 1000].
 * -1000 <= Node.val <= 1000
 * The value of each node in the list is unique.
 * The node to be deleted is in the list and is not a tail node.
 * <p>
 * Leetcode link : https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class DeleteNodeInALinkedList {

    public void deleteNodeInSimpleWay(ListNode node) {
        node.val = node.next.val;
        node.next= node.next.next;

    }

    public void deleteNode(ListNode node) {

        ListNode current = node;
        ListNode prev = null;
        while (current.next != null) {
            prev = current;
            current.val = current.next.val;
            current = current.next;
        }
        if (prev != null) {
            prev.next = null;
        }

    }
}
