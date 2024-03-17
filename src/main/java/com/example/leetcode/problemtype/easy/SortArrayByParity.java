package com.example.leetcode.problemtype.easy;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * <p>
 * Return any array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 * <p>
 * Leetcode link : https://leetcode.com/problems/sort-array-by-parity/description/
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {

        int evenIndex = 0;
        int oddIndex = nums.length - 1;

        while (evenIndex < oddIndex) {
            while (evenIndex <= oddIndex) {
                if (nums[evenIndex] % 2 == 0) {
                    evenIndex++;
                } else {
                    break;
                }
            }
            while (oddIndex >= evenIndex) {
                if (nums[oddIndex] % 2 != 0) {
                    oddIndex--;
                } else {
                    break;
                }
            }
            if (evenIndex < oddIndex) {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
                evenIndex++;
                oddIndex--;
            }
        }
        return nums;
    }
    public int[] sortArrayByParity2(int[] A) {
        int i =0,j = A.length-1;
        while(i<j){

            while(A[i] %2 ==0 && i<A.length-1){
                i++;
            }
            while(A[j] %2 !=0 && j>0){
                j--;
            }

            if(i<j){
                swap(A,i,j);
                i++;
                j--;
            }
        }
        return A;

    }
    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] =a[j];
        a[j] = temp;

    }
}
