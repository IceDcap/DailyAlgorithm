package com.icedcap.interview.string;

/**
 * 判断两个字符串是否互为变形次
 */
public class S1 {

    public boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;
        int[] dict = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            dict[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (dict[str2.charAt(i)]-- == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new S1().isDeformation("abc", "bca"));
        System.out.println(new S1().isDeformation("ab+ic0", "0bca+"));
    }
}
