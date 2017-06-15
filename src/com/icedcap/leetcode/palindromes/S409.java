package com.icedcap.leetcode.palindromes;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Palindrome(E)
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class S409 {

    public int longestPalindrome(String s) {
        if (null == s || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (!set.isEmpty()) return count * 2 + 1;
        else return count * 2;
    }

    public static void main(String[] args) {
        String str = "dccaccd";
        System.out.println(new S409().longestPalindrome(str));
    }
}
