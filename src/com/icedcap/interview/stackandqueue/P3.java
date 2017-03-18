package com.icedcap.interview.stackandqueue;

import java.util.Stack;

/**
 * 使用递归逆序一个栈结构
 */
public class P3 {

    //将栈底元素返回并且移除
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int curr = stack.pop();
        if (stack.empty()) {
            return curr;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(curr);
            return last;
        }
    }

    //反转一个栈
    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(getAndRemoveLastElement(stack));
        System.out.println(stack.peek());
    }
}
