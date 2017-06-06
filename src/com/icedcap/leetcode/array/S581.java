package com.icedcap.leetcode.array;

import java.util.Arrays;

/**
 * Shortest Unsorted Continuous Subarray(E)
 * <p>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class S581 {
    public int findUnsortedSubarray(int[] nums) {
        int size = nums.length;
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = nums[i];
        }
        int s = 0;
        Arrays.sort(temp);
        while (s < size && temp[s] == nums[s]) s++;

        int e = size - 1;
        while (e >= s && temp[e] == nums[e]) e--;

        return e - s + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int res = new S581().findUnsortedSubarray(nums);
        System.out.println(res);
    }
}
