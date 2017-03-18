package com.icedcap.leetcode.array;

/**
 * 209. Minimum Size Subarray Sum(M)
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class S209 {
    //暴力
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0, count = 0;
            for (int j = i; j< len;j++) {
                sum += nums[j];
                count++;
                if (sum >= s) {
                    if (count < min) min = count;
                    break;
                }
            }
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}
