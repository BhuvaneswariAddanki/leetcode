package com.example.leetcode.problemtype.easy;

/**
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 * <p>
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
 * <p>
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
 * <p>
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
 * <p>
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
 * <p>
 * Example 2:
 * <p>
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 * <p>
 * Leetcode link : https://leetcode.com/problems/distribute-candies-to-people/description/
 */
public class DistributeCandiesToPeople {

    public int[] distributeCandiesBruteforce(int candies, int num_people) {
        int[] result = new int[num_people];
        int candiesToBeGiven = 1;
        int index = 0;
        while (candies > 0) {
            if (candiesToBeGiven > candies) {
                result[index] = result[index] + candies;
                break;
            } else {
                result[index] = result[index] + candiesToBeGiven;
                candies -= candiesToBeGiven;
                candiesToBeGiven++;
                index = (index + 1) % num_people;
            }
        }
        return result;
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        long c = (long) candies;
        long n = (long) num_people;
        int rows = (int) (-n + Math.sqrt(n * n + 8 * n * n * c)) / (int) (2 * n * n);
        int accumN = rows * (rows - 1) * num_people / 2;

        for (int i = 0; i < n; ++i)
            ans[i] = accumN + rows * (i + 1);

        int givenCandies = (num_people * num_people * rows * rows + num_people * rows) / 2;
        candies -= givenCandies;

        for (int i = 0, lastGiven = rows * num_people + 1; candies > 0; ++i, ++lastGiven) {
            int actualGiven = Math.min(lastGiven, candies);
            candies -= actualGiven;
            ans[i] += actualGiven;
        }

        return ans;
    }

}
