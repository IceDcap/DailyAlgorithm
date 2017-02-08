package com.icedcap.basicsort;

/**
 * Created by doushuqi on 17-2-8.
 */
public class InsertionSort {

    public void insertionSort(int[] num) {
        int len = num.length;
        for (int i = 0; i < len; i++) {
            int index = i, index_num = num[i];
            while (index > 0 && num[index - 1] > index_num) {
                num[index] = num[index - 1];
                index--;
            }
            num[index] = index_num;
        }
    }

    /**
     * base on the logic of insertion sort gif.
     */
    public void insertionSort2(int[] num) {
        int len = num.length;
        for (int i = 0; i < len; i++) {
            int tmp_i = i;
            while (tmp_i > 0 && num[tmp_i-1] > num[tmp_i]) {
                int tmp_v = num[tmp_i-1];
                num[tmp_i-1] = num[tmp_i];
                num[tmp_i] = tmp_v;
                tmp_i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {5, 7, 1, 4, 3, 10};
        new InsertionSort().insertionSort2(num);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
