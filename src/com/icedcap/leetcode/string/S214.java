package com.icedcap.leetcode.string;

/**
 * 214. Shortest Palindrome(H)
 * <p>
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * For example:
 * <p>
 * Given "aacecaaa", return "aaacecaaa".
 * <p>
 * Given "abcd", return "dcbabcd".
 */
public class S214 {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) i++;
        }
        if (i == s.length()) return s;
        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix + mid + suffix;
    }

    public static void main(String[] args) {
//        System.out.println(new S214().shortestPalindrome("aacecaaa"));
//        System.out.println(new S214().shortestPalindrome("abcd"));
        System.out.println(new S214().shortestPalindrome("adcba"));
    }
}
