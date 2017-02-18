package com.icedcap.leetcode.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 3. Longest Substring Without Repeating Characters(M)
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class S3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        char[] set = new char[128];
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            while (set[ch]==1){
                set[queue.poll()]--;
            }
            if (set[ch]==0) {
                set[ch]++;
                queue.offer(ch);
                max = Math.max(max, queue.size());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        new S3().lengthOfLongestSubstring("abcabcbb");
    }
}
