package com.example.leetcode.problemtype.medium;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        int res = obj.findDuplicate(nums);
        System.out.println(res);
    }

    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
