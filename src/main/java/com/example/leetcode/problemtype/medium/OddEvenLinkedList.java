package com.example.leetcode.problemtype.medium;

import com.example.leetcode.ListNode;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 * <p>
 * Leetcode link : https://leetcode.com/problems/odd-even-linked-list/description/
 */
public class OddEvenLinkedList {
    /**
     * We maintain two pointers: odd and even, which represent the last odd-indexed node and the last even-indexed node, respectively.
     * We iterate through the linked list, connecting odd-indexed nodes and even-indexed nodes separately.
     * Finally, we link the last odd-indexed node to the first even-indexed node to form the reordered list.
     * Complexity:
     * <p>
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as we are not using any additional data structures.
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        while (evenNode != null && evenNode.next != null) {

            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }
}
