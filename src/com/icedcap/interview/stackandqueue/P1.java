package com.icedcap.interview.stackandqueue;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 实现一个栈，并且带有一个返回栈中最小值的函数
 * 要求：
 * 1.pop push getMin操作的时间复杂度都是O(1)
 * 2.设计栈类型可以使用现成的栈结构
 */
public class P1 {
    //方案一：入栈时判断minStack是否为空，如果为空压栈
    //如果不为空，判断要入栈的值是否小于minStack栈顶值，如果小则入最小栈
    //否则不做任何操作
    //弹栈时判断当前被弹的值是否和最小栈minStack栈顶值相同，如果相同同样也要弹出
    static class Stack1{
        private int[] elementData = new int[100];
        private int index = 0;
        private Stack<Integer> minStack = new Stack<>();

        public void push(int val) {
            if (index >= elementData.length) {
                throw new IllegalArgumentException("out of size");
            }
            elementData[index++] = val;
            if (minStack.empty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public int pop() {
            if (index < 0) {
                throw new IllegalArgumentException("stack is empty");
            }
            int pop = elementData[index--];
            if (pop == minStack.peek()) {
                minStack.pop();
            }
            return pop;
        }

        public int getMin() {
            if (minStack.empty()) {
                throw new IllegalArgumentException("stack is empty");
            }
            return minStack.peek();
        }
    }


    //方案二
    //入栈时，判断入栈值是否小于minStack栈顶值，如果小于或等于则将它入栈minStack，如果
    //大于栈顶值，则将minStack栈顶值再次入栈minStack
    //弹栈时，minStack也同时弹
    //getMin方法每次都返回minStack栈顶值
    static class Stack2 {
        private Stack<Integer> valStack;
        private Stack<Integer> minStack;

        public Stack2() {
            valStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            valStack.push(val);
            if (minStack.empty() || val <= getMin()) {
                minStack.push(val);
            }else {
                minStack.push(getMin());
            }
        }

        public int pop() {
            if (valStack.empty()) throw new IllegalArgumentException("stack is empty");
            minStack.pop();
            return valStack.pop();
        }


        public int getMin() {
            if (minStack.empty()) throw new IllegalArgumentException("stack is empty");
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Stack2 stack2 = new Stack2();
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        System.out.println(stack2.getMin());
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.push(1);
        stack2.push(2);
        stack2.push(1);
        System.out.println(stack2.getMin());
        stack2.pop();
        System.out.println(stack2.getMin());
        stack2.pop();
        System.out.println(stack2.getMin());
        stack2.pop();
    }
}
