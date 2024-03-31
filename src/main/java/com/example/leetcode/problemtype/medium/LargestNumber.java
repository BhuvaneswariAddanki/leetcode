package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * Leetcode link : https://leetcode.com/problems/largest-number/description/
 */
public class LargestNumber {

        public String largestNumber(int[] nums) {

            String[] numbers = new String[nums.length];
            StringBuilder result = new StringBuilder();
            int i =0;
            for(int num : nums){
                numbers[i++] = String.valueOf(num);
            }
            Arrays.sort(numbers, (n1, n2) -> (n2+n1).compareTo(n1+n2) );

            for(String number : numbers){
                result.append(number);
            }
            String res = result.toString();

            if(res.charAt(0) == '0'){
                return "0";
            }else{
                return res;
            }
    }
}
