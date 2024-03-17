package com.example.leetcode.problemtype.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 997. Find the Town Judge
 * <p>
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * <p>
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 * <p>
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 * Leetcode link : https://leetcode.com/problems/find-the-town-judge/description/
 */
public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {

        Map<Integer, Integer> trustCountMap = new HashMap<>();
        for (int[] trustEntry : trust) {
            trustCountMap.put(trustEntry[1], trustCountMap.getOrDefault(trustEntry[1], 0) + 1);
            trustCountMap.put(trustEntry[0], trustCountMap.getOrDefault(trustEntry[0], 0) - 1);
        }
        return trustCountMap.entrySet()
                .stream()
                .filter(entry -> Integer.valueOf(n - 1).equals(entry.getValue()))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);

    }

    public int findJudgeUsingArray(int N, int[][] trust) {

        int[] result = new int[N + 1];

        for (int[] t : trust) {
            result[t[0]]--;
            result[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == N - 1) {
                return i;
            }
        }

        return -1;

    }
}
