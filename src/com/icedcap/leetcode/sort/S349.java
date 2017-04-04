package com.icedcap.leetcode.sort;

import java.util.*;

/**
 * 349. Intersection of Two Arrays(E)
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 */
public class S349 {

    public int[] intersection(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);

        Set<Integer> intersect = new HashSet<>();
        int i = 0, j = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] == num2[j]) {
                intersect.add(num1[i]);
                i++;
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[intersect.size()];
        int k = 0;
        for (int num : intersect) {
            res[k++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] result = new S349().intersection(num1, num2);
        System.out.println(Arrays.toString(result));
    }
}
