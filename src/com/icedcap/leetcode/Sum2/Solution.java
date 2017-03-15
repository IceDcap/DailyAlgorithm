package com.icedcap.leetcode.Sum2;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there
 * are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length <= 0 ||
                B == null || B.length <= 0 ||
                C == null || C.length <= 0 ||
                D == null || D.length <= 0) {
            return 0;
        }

        int result = 0;
        Map<Integer, Integer> dict = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                dict.put(sum, (dict.get(sum) == null ? 0 : dict.get(sum)) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                result += dict.get(-sum) == null ? 0 : dict.get(-sum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        int result = new Solution().fourSumCount(A, B, C, D);
        System.out.println(result);
    }
}
