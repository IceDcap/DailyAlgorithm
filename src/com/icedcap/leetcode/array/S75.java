package com.icedcap.leetcode.array;

/**
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class S75 {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int low = 0, height = nums.length - 1;
        for(int i = 0; i <= height;) {
            if(nums[i] == 0) {
                int tmp = nums[low];
                nums[low] = nums[i];
                nums[i] = tmp;
                low++;
                i++;
            }else if(nums[i] == 2) {
                int tmp = nums[height];
                nums[height] = nums[i];
                nums[i] = tmp;
                height--;
            } else {
                i++;
            }
        }
    }
}
