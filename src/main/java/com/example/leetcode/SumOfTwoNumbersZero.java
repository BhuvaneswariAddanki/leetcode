package com.example.leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfTwoNumbersZero {
    public static void main(String[] args) {
        SumOfTwoNumbersZero sumOfTwoNumbersZero = new SumOfTwoNumbersZero();
        List<List<Integer>> result = sumOfTwoNumbersZero.findTwoElements(new int[]{2, 3, -4, -3, -1, 4}, 0);
        System.out.print(result);

    }

    public List<List<Integer>> findTwoElements(int[] nums, int sum) {

        Set<Integer> numsSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int n : nums) {
            if (numsSet.contains(sum - n)) {
                result.add(List.of(n, sum - n));
            } else {
                numsSet.add(n);
            }
        }
        return result;

    }
}
