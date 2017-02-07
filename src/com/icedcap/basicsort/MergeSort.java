package com.icedcap.basicsort;

/**
 * Created by doushuqi on 17-2-7.
 */
public class MergeSort {

    // base on argument change, use a helper array.
    private int[] merge(int[] num, int low, int mid, int high) {
        //help space O(n)
        int[] copy = new int[num.length];
        for (int i = low; i <= high; i++) {
            copy[i] = num[i];
        }

        int j = low, k = mid + 1;
        for (int i = low; i <= high; i++) {
            // i means current position.
            if (j > mid) {
                num[i] = copy[k];
                k++;
            } else if (k > high) {
                num[i] = copy[j];
                j++;
            } else if (copy[j] < copy[k]) {
                num[i] = copy[j];
                j++;
            } else {
                num[i] = copy[k];
                k++;
            }
        }
        return num;
    }

    private void sort(int[] num, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        sort(num, low, mid);
        sort(num, mid + 1, high);
        merge2(num, low, mid, high);
    }


    public void mergeSort(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        sort(num, 0, num.length - 1);
    }

    // another recursion method
    public void merge2(int[] num, int low, int mid, int high) {
        int i = low, j = mid + 1;
        int count = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (num[i] < num[j]) {
                temp[count++] = num[i++];
            } else {
                temp[count++] = num[j++];
            }
        }

        while (i <= mid) {
            temp[count++] = num[i++];
        }
        while (j <= high) {
            temp[count++] = num[j++];
        }
        count = 0;
        while (low <= high) {
            num[low++] = temp[count++];
        }
    }

    /*******************************
     * non-recursion merge sort
     *******************************/
    public void nonRecursionMergeSort(int[] num) {
        int len = 1;
        while(len < num.length){
            for(int i = 0; i < num.length; i += 2*len){
                nonRecursionMerge(num, i, len);
            }
            len *= 2;
        }
    }

    private void nonRecursionMerge(int[] num, int i, int len) {
        int start = i;
        int len_i = i + len;//归并的前半部分数组
        int j = i + len;
        int len_j = j + len;//归并的后半部分数组
        int[] temp = new int[2 * len];
        int count = 0;
        while (i < len_i && j < len_j && j < num.length) {
            if (num[i] <= num[j]) {
                temp[count++] = num[i++];
            } else {
                temp[count++] = num[j++];
            }
        }

        while (i < len_i && i < num.length) {
            temp[count++] = num[i++];
        }
        while (j < len_j && j < num.length) {
            temp[count++] = num[j++];
        }
        count = 0;
        while(start < j && start < num.length){
            num[start++] = temp[count++];
        }

    }

    public static void main(String[] args) {
        int[] num = {5, 7, 1, 4, 3, 10};
//        new MergeSort().mergeSort(num);
        new MergeSort().nonRecursionMergeSort(num);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
