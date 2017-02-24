package com.icedcap.leetcode.string;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 32. Longest Valid Parentheses(H)
 * <p>
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class S32 {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new S32().longestValidParentheses("()(()"));
    }
}
