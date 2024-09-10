package com.example.leetcode.problemtype.easy;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * Easy
 * Topics
 * Companies
 * <p>
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Implement KthLargest class:
 * <p>
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * At most 104 calls will be made to add.
 * It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 * <p>
 * <p>
 * Leetcode link : https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class KthLargestElementInaStream {

    PriorityQueue<Integer> priorityQueue;
    private final int k;


    public KthLargestElementInaStream(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>();
        for (int n : nums) {
            priorityQueue.offer(n);
        }
        limitToKNumbers();
    }

    private void limitToKNumbers() {
        int n = priorityQueue.size();
        for (int i = 0; i < n - k; i++) {
            priorityQueue.remove();
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        limitToKNumbers();
        return priorityQueue.peek();

    }

}
