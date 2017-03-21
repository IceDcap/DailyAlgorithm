package com.icedcap.leetcode.backtracking;

import com.icedcap.interview.string.S3;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning(M)
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class S131 {
    ArrayList<String> curList;
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        curList = new ArrayList<>();
        result = new ArrayList<List<String>>();
        backTrack(s, 0);
        return result;
    }

    public void backTrack(String str, int l) {
        if (curList.size() > 0 && l >= str.length()) {
            List<String> r = (ArrayList<String>) curList.clone();
            result.add(r);
        }

        for (int i = l; i < str.length(); i++) {
            if (isPalindrome(str, l, i)) {
                if (l == i) curList.add(Character.toString(str.charAt(l)));
                else curList.add(str.substring(l, i + 1));
                backTrack(str, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
