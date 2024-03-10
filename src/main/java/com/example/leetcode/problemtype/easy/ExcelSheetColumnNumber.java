package com.example.leetcode.problemtype.easy;

/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: columnTitle = "A"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: columnTitle = "AB"
 * Output: 28
 * <p>
 * Example 3:
 * <p>
 * Input: columnTitle = "ZY"
 * Output: 701
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 * leetcode link : https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
