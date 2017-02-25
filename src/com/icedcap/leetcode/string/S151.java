package com.icedcap.leetcode.string;

import java.util.Stack;

/**
 * 151. Reverse Words in a String(M)
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 */
public class S151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
