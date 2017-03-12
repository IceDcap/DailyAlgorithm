package com.icedcap.leetcode.math;

/**
 * 172. Factorial Trailing Zeroes(M)
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.
 */
public class S172 {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
