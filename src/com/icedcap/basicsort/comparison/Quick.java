package com.icedcap.basicsort.comparison;

/**
 * Quick Sort.
 * O(nlgn) time.
 */
public class Quick {

    /**
     * Recursive to part the sequence.
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * One time to part the sequence.
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        while (left < right) {
            while (left < right && arr[right] >= arr[left]) right--;
            swap(arr, left, right);
            while (left < right && arr[left] <= arr[right]) left++;
            swap(arr, left, right);
        }
        return left;
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }
}
