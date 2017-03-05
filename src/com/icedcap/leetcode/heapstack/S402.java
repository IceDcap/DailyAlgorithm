package com.icedcap.leetcode.heapstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. Remove K Digits(M)
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class S402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k == 0) return num;
        if (num.length() <= k) return "0";
        Deque<Character> stack = new ArrayDeque<>();
        int count = k, resultLen = num.length() - k;
        for (char ch : num.toCharArray()) {
            while (count > 0 && !stack.isEmpty() && stack.peekLast() > ch) {
                stack.pollLast();
                count--;
            }
            stack.offerLast(ch);
        }

        //remove first element '0'
        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.pollFirst();
            resultLen--;
        }

        if (stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder(resultLen);
        while (!stack.isEmpty() && resultLen >0){
            sb.append(stack.pollFirst());
            resultLen--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new S402().removeKdigits("1432219", 3));
//        System.out.println(new S402().removeKdigits("9", 1));
        System.out.println(new S402().removeKdigits("112", 1));

    }
}
