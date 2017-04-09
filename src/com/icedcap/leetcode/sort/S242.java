package com.icedcap.leetcode.sort;

import java.util.Arrays;

/**
 * 242. Valid Anagram(E)
 * <p>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class S242 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != tt[i]) return false;
        }
        return true;
    }
}
