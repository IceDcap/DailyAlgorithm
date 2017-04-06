package com.icedcap.leetcode.sort;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II(M)
 * <p>
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * <p>
 * Note:
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class S324 {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    //https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivotPos = partition(nums, left, right);
        quickSort(nums, left, pivotPos - 1);
        quickSort(nums, pivotPos + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public void wiggleSort2(int[] nums) {
        int median = findKthLargest2(nums, (nums.length + 1) / 2);
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int[] tmpArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > median) {
                tmpArr[odd] = nums[i];
                odd += 2;
                continue;
            }
            if (nums[i] < median) {
                tmpArr[even] = nums[i];
                even -= 2;
                continue;
            }
        }
        while (odd < nums.length) {
            tmpArr[odd] = median;
            odd += 2;
        }
        while (even >= 0) {
            tmpArr[even] = median;
            even -= 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArr[i];
        }
    }

    //https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
    public int findKthLargest2(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}
