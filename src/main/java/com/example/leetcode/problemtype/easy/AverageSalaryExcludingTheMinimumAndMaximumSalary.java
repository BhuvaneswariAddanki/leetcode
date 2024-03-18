package com.example.leetcode.problemtype.easy;

/**
 * You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
 * <p>
 * Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: salary = [4000,3000,1000,2000]
 * Output: 2500.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
 * Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
 * <p>
 * Example 2:
 * <p>
 * Input: salary = [1000,2000,3000]
 * Output: 2000.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
 * Average salary excluding minimum and maximum salary is (2000) / 1 = 2000
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= salary.length <= 100
 * 1000 <= salary[i] <= 106
 * All the integers of salary are unique.
 * <p>
 * Leetcode link :  https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salaries) {

        int sum = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = 0;
        for (int salary : salaries) {
            minSalary = Math.min(minSalary, salary);
            maxSalary = Math.max(maxSalary, salary);
            sum += salary;
        }
        return (sum - minSalary - maxSalary) / Double.valueOf (salaries.length - 2);
    }
}
