package com.icedcap.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets(M)
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class S78 {
    private List<List<Integer>> result;
    private List<Integer> temp;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(0, nums);
        return result;
    }

    private void dfs(int start, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

}
