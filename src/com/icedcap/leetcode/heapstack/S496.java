package com.icedcap.leetcode.heapstack;

import java.util.*;

/**
 * 496. Next Greater Element I(E)
 * <p>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */
public class S496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        //暴力法
        int[] result = new int[findNums.length];
        int count = 0;
        for (int i : findNums) {
            for (int index = 0; index < nums.length; index++) {
                if (i == nums[index]) {
                    int tmp = i;
                    index += 1;
                    while (index < nums.length) {
                        if (tmp < nums[index]) {
                            tmp = nums[index];
                            break;
                        }
                        index++;
                    }
                    result[count++] = tmp == i ? -1 : tmp;
                    break;
                }
            }
        }
        return result;
    }

    //使用栈
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        return findNums;

    }

    public static void main(String[] args) {
//        int[] nextGreaterElement = new S496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        int[] nextGreaterElement = new S496().nextGreaterElement2(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
//        int[] nextGreaterElement = new S496().nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7});

        for (int i : nextGreaterElement) {
            System.out.println(i);
        }
    }
}
