package com.icedcap.leetcode.heapstack;

import com.sun.tools.javah.Util;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation(M)
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class S150 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (!str.equals("+") && !str.equals("-") &&
                    !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.decode(str));
            } else {
                int num2 = !stack.empty() ? stack.pop() : 0;
                int num1 = !stack.empty() ? stack.pop() : 0;
                int tmp = 0;
                if (str.equals("+")) tmp = num1 + num2;
                if (str.equals("-")) tmp = num1 - num2;
                if (str.equals("*")) tmp = num1 * num2;
                if (str.equals("/") && num2 != 0) tmp = num1 / num2;
                stack.push(tmp);
            }
        }
        return stack.empty() ? 0 : stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new S150().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new S150().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
