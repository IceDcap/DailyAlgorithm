package com.icedcap.basicsort.comparison;

/**
 * Shell Sort.
 */
public class Shell {

    /**
     * Effect Direct Insert Sort.
     * @param arr
     * @param d
     */
    private static void shellInsert(int[] arr, int d/*offset*/) {
        for (int i = d; i < arr.length; i++) {
            int target = arr[i], j = i;
            while (j > 0 && target < arr[j - d]) {
                arr[j] = arr[j - d];
                j -= d;
            }
            arr[j] = target;
        }
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int d = arr.length / 2;
        while (d >= 1) {
            shellInsert(arr, d);
            d /= 2;
        }
    }
}
