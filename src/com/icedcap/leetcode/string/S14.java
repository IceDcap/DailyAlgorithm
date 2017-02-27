package com.icedcap.leetcode.string;

/**
 * 14. Longest Common Prefix(E)
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class S14 {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new S14().longestCommonPrefix(new String[]{"abcd", "abcjdh", "abcqwjh"}));
    }
}