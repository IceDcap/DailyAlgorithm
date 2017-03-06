package com.icedcap.basicsort.comparison;

/**
 * Selection Sort.
 * O(n^2) time, O(1) space.
 * 每趟选出最小值的下标，然后如果不是当前基准点为最小值那么就和该趟的基准点进行交换。
 */
public class Selection {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
//        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
