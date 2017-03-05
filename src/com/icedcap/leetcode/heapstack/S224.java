package com.icedcap.leetcode.heapstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator(H)
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 */
public class S224 {
    public int calculate(String s) {
        int result = 0, len = s.length(), sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int tmp = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += tmp * sign;
                i--;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new S224().calculate("1 + 1"));
        System.out.println(new S224().calculate(" 2-1 + 2 "));
        System.out.println(new S224().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
