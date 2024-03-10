package com.example.leetcode.problemtype.easy;

import com.example.leetcode.ListNode;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * Custom Judge:
 * <p>
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * <p>
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * <p>
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
 * If you correctly return the intersected node, then your solution will be accepted.
 * <p>
 * Leetcode link : https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * The naive approach here would be to store each node reference in a data structure until we saw the same one twice,
     * but that would take O(N) extra space.
     * <p>
     * In order to solve this problem with only O(1) extra space, we'll need to find another way to align the two linked lists.
     * More importantly, we need to find a way to line up the ends of the two lists.
     * And the easiest way to do that is to concatenate them in opposite orders, A+B and B+A.
     * <p>
     * This way, the ends of the two original lists will align on the second half of each merged list.
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        while (first != second) {
            first = first == null ? headB : first.next;
            second = second == null ? headA : second.next;
        }
        return first;
    }
}

