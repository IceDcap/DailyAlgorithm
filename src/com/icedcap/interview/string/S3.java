package com.icedcap.interview.string;

/**
 * 去掉字符串中连续出现k个0的子串
 */
public class S3 {

    public static String removeKofZeroString(String str, int k) {
        if (str == null || k < 1) return str;
        int count = 0, start = -1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (str.charAt(i) == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count--!=0) {
                        chars[start++] = 0;
                    }
                    count = 0;
                    start = -1;
                }

            }
        }
        if (count == k) {
            while (count-- != 0) {
                chars[start++] = 0;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(removeKofZeroString("ab000cd", 3));
    }
}
