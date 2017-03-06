package com.icedcap.basicsort.comparison;

/**
 * Created by icedcap on 06/03/2017.
 */
public class CompareSortTest {

    public static void main(String[] args) {
        int[] sequence = {3, 2, 7, 1, 5, 9, 0};
//        Bubble.bubbleSort(sequence);
//        Selection.selectionSort(sequence);
//        Insertion.insertionSort(sequence);
//        Quick.sort(sequence);
//        Shell.shellSort(sequence);
        Merge.mergeSort(sequence);

        System.out.print("[ ");
        for (int i : sequence) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}
