package com.icedcap.interview.stackandqueue;

import java.util.Stack;

/**
 * 用一个栈实现另外一个栈的排序
 */
public class P5 {
    //思路：
    //将待排序的栈记为stack，辅助栈记为help
    //每次从stack中弹出的数位cur，如果cur小于等于help栈顶元素就压入help
    //如果大于的话，将依次从help中弹出栈顶元素并压入stack直到cur小于等于help栈顶元素


    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!help.empty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        sortStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
