package com.icedcap.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number(M)
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class S179 {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(s_nums, comparator);
        if (s_nums[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : s_nums) {
            sb.append(s);
        }
        return sb.toString();
    }
}
