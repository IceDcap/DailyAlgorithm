package com.icedcap.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses(M)
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class S22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    private void dfs(List<String> res, int left, int right, String rec) {
        if (left == 0 && right == 0) {
            res.add(rec);
        }
        if (left > 0) {
            dfs(res, left - 1, right, rec + "(");
        }
        if (right > left) {
            dfs(res, left, right - 1, rec + ")");
        }
    }

    public static void main(String[] args) {
        List<String> res = new S22().generateParenthesis(2);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
