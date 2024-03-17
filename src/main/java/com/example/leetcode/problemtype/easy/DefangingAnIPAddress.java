package com.example.leetcode.problemtype.easy;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * <p>
 * Example 2:
 * <p>
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given address is a valid IPv4 address.
 * Leetcode link : https://leetcode.com/problems/defanging-an-ip-address/description/
 */
public class DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
