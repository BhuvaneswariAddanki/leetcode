package com.example.leetcode.problemtype.easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The input must be a binary string of length 32
 * <p>
 * Leetcode link : https://leetcode.com/problems/reverse-bits/description/
 */
public class ReverseBits {

    /**
     * Let's understand in terms of decimal number to understand how the code is implemented
     * Suppose we have a number 12345678 and we have to reverse it to get 87654321 as desired output
     * The process will be as follows:
     * 12345678 --> original number
     * <p>
     * 56781234
     * 78563412
     * 87654321 --> desired number(reversed number)
     *
     * @param num
     * @return
     */
    public int reverseBits(int num) {

        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);

        return num;

    }

    public int reverseBitsUsingLeftshift(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
