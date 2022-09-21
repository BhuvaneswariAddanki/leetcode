package com.example.leetcode;

/**
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        NextGreaterElementI obj = new NextGreaterElementI();
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        int[] res = obj.nextGreaterElement(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = -1;
            result[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    index = j;
                    break;
                }
            }
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }

        }
        return result;
    }
}
