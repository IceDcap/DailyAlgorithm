package com.icedcap.leetcode.math;

import java.util.Arrays;

/**
 * 475. Heaters(E)
 * <p>
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class S475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) index = -(index + 1);
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            radius = Math.max(radius, Math.min(dist1, dist2));
        }

        return radius;
    }

    public static void main(String[] args) {
        S475 instance = new S475();
//        System.out.println(instance.findRadius(new int[]{1, 2, 3}, new int[]{2}));
//        System.out.println(instance.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
//        System.out.println(instance.findRadius(new int[]{1, 5}, new int[]{2}));
        System.out.println(instance.findRadius(new int[]{1, 2, 3, 5, 15}, new int[]{2, 30}));
    }
}