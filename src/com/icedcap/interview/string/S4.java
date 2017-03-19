package com.icedcap.interview.string;

import java.util.Arrays;

/**
 * 判断两个字符串是否为旋转词
 * abcd bcda cdab dabc
 */
public class S4 {
    public static boolean isRotationWord(String origin, String rotation) {
        if (origin == null || rotation == null || origin.length() != rotation.length()) return false;
        String helpStr = rotation + rotation;
        //KMP算法
        search(helpStr, origin, getNext(origin));
        return false;
    }

    public static void search(String original, String find, int next[]) {
        int j = 0;
        for (int i = 0; i < original.length(); i++) {
            while (j > 0 && original.charAt(i) != find.charAt(j))
                j = next[j];
            if (original.charAt(i) == find.charAt(j))
                j++;
            if (j == find.length()) {
                System.out.println("find at position " + (i - j));
                System.out.println(original.subSequence(i - j + 1, i + 1));
                j = next[j];
            }
        }
    }

    public static int[] getNext(String b) {
        int len = b.length();
        int j = 0;

        int next[] = new int[len + 1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0] = next[1] = 0;

        for (int i = 1; i < len; i++)//i表示字符串的下标，从0开始
        {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            while (j > 0 && b.charAt(i) != b.charAt(j)) j = next[j];
            if (b.charAt(i) == b.charAt(j)) j++;
            next[i + 1] = j;
        }

        return next;
    }

    public static void main(String[] args) {

    }
}
