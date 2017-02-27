package com.icedcap.leetcode.heapstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II Add to List(M)
 * <p>
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
public class S503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                result[stack.pop()] = num;
            if (i < n) stack.push(i);//将数组下标压入栈
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = new S503().nextGreaterElements(new int[]{1, 2, 1});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
