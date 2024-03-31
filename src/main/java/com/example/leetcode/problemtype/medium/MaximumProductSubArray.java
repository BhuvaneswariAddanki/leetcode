package com.example.leetcode.problemtype.medium;

/**
 * Given an integer array nums, find a
 * subarray
 * that has the largest product, and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * Leetcode link : https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubArray {
    /**
     * Intuition
     * <p>
     * The Brute force method says we can simply apply 2 loops for calculaing all sub-arrays and finding the max product.
     * <p>
     * But, the Optizimed way to solve this problem is using Kadane's Algorithm.
     * Approach
     * <p>
     * The Approach to this question is exactly same as Kadane's Algo the only differece is, we will be traversing the array from both sides i.e left to right ( lets say the max prod is maxi1 ) and from right to left ( say max prod is maxi2 ), now the final answer will we max of maxi1 and maxi2.
     * <p>
     * Ques : Why do we have a need to traverse from right to left ??
     * Ans : lets take an example
     * arr {-8,5,3,1,6}
     * <p>
     * // By traversing left to right we have an answer maxi1.
     * maxi1 = -720 , which is clearly not the max prod value.
     * <p>
     * -> The whole concept lies in this statement - As we can see that there is only 1 negative no. ( if we consider that no. then the final answer can never be positive ), therefore to avoid this situation we also traverse from right to left to get the final maximum prod.
     * Complexity
     * <p>
     * Time complexity:
     * O(N) + O(N) = O(N), where N is size of array.
     * <p>
     * Space complexity:
     * O(1)
     */

    public int maxProduct(int[] nums) {

        int productSoFar = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int num : nums) {
            productSoFar *= num;
            maxProduct = Math.max(productSoFar, maxProduct);
            if (productSoFar == 0) {
                productSoFar = 1;
            }
        }
        productSoFar = 1;
        int maxProduct2 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            productSoFar *= nums[i];
            maxProduct = Math.max(productSoFar, maxProduct);
            if (productSoFar == 0) {
                productSoFar = 1;
            }
        }
        return Math.max(maxProduct, maxProduct2);
    }

    public int maxProductInOnePass(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int minProduct = nums[0];
        int maxProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = minProduct;
                minProduct = maxProduct;
                maxProduct = temp;
            }
            minProduct = Math.min(minProduct * nums[i], nums[i]);
            maxProduct = Math.max(maxProduct * nums[i], nums[i]);
            answer = Math.max(answer, maxProduct);
        }
        return answer;
    }

    public int maxProductBruteForce(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        for (int p = 0; p < nums.length; p++) {
            int product = 1;
            for (int i = p; i < nums.length; i++) {
                product *= nums[i];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;

    }

}
