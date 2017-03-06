package com.icedcap.basicsort.comparison;

/**
 * Insertion Sort
 * O(n^2) time, O(1) space.
 */
public class Insertion {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j-1];//后移
                j--;
            }
            //插入
            arr[j] = target;
        }
    }
}
