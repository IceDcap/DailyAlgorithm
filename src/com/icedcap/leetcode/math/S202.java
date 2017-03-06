package com.icedcap.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number(E)
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class S202 {
    public boolean isHappy(int n) {
        Set<Integer> isLoop = new HashSet<>();
        while (isLoop.add(n)) {
            int tmp = squareOfSingle(n);
            if (tmp == 1) return true;
            else n = tmp;
        }
        return false;
    }

    private int squareOfSingle(int d) {
        int sum = 0;
        while (d > 0) {
            sum += (d % 10) * (d % 10);
            d /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new S202().isHappy(9));
//        System.out.println(new S202().squareOfSingle(1111111));
    }
}
