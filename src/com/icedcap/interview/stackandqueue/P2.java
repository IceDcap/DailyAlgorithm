package com.icedcap.interview.stackandqueue;

import java.util.Stack;

/**
 * 用两个栈结构实现一个队列，支持基本操作add poll peek
 */
public class P2 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public P2(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(int val) {
        stack1.push(val);
    }

    public int poll() {
        if (stack2.empty()) {
            if (stack1.empty()) throw new IllegalArgumentException("queue is empty");
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        P2 instance = new P2();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        System.out.println(instance.peek());
        instance.poll();
        System.out.println(instance.poll());
        instance.add(4);
        instance.add(5);
        instance.add(6);
        System.out.println(instance.poll());
        System.out.println(instance.poll());
        System.out.println(instance.poll());
        System.out.println(instance.poll());
        System.out.println(instance.poll());
    }
}
