package com.icedcap.leetcode.heapstack;

import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums(M)
 * <p>
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * <p>
 * Return: [1,2],[1,4],[1,6]
 * <p>
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * <p>
 * Return: [1,1],[1,1]
 * <p>
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3
 * <p>
 * Return: [1,3],[2,3]
 * <p>
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 */
public class S373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(new int[]{i, j}, (nums1[i] + nums2[j]));
            }
        }
        Integer[] values = new Integer[map.size()];
        map.values().toArray(values);
        Arrays.sort(values);
        List<int[]> result = new ArrayList<>();
        for (int num : values) {
            for (int[] key : map.keySet()) {
                int[] pairs = {nums1[key[0]], nums2[key[1]]};
                if (map.get(key) != null && num == map.get(key)) {
                    result.add(pairs);
                    map.put(key, null);
                    break;
                }
            }
            if (result.size() >= k) break;
        }
        return result;
    }


    //429ms beats 0.28%
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                list.add(new Pair(nums1[i], nums2[j]));
            }
        }
        Pair[] pairs = new Pair[list.size()];
        Arrays.sort(list.toArray(pairs));
        List<int[]> ret = new ArrayList<>();
        for (Pair p : pairs) {
            ret.add(p.pair);
            if (ret.size() >= k) break;
        }
        return ret;
    }

    class Pair implements Comparable<Pair> {
        int[] pair;
        int sum;

        Pair(int num1, int num2) {
            pair = new int[]{num1, num2};
            sum = num1 + num2;
        }

        @Override
        public int compareTo(Pair o) {
            return sum - o.sum;
        }
    }


    public static void main(String[] args) {
//        int[] nums1 = {1, 1, 2};
        int[] nums1 = {-10, -4, 0, 0, 6};
//        int[] nums2 = {1, 2, 3};
        int[] nums2 = {3, 5, 6, 7, 8, 100};
        List<int[]> result = new S373().kSmallestPairs2(nums1, nums2, 10);
        for (int[] num : result) {
            System.out.println("[" + num[0] + " , " + num[1] + "]");
        }
    }

}
