package com.icedcap.interview.string;

/**
 * 将字符串转化为整数
 * "123" -> 123
 * "023" -> 0 023不符合日常书写规范
 * "A13" -> 0
 * "2147483647" -> 2147483647
 * "2147483648" -> 0 因为溢出了
 * "-123" -> -123
 */
public class S5 {

    public static boolean isValid(char[] chars) {
        if (chars[0] != '-' && chars[0] < '0' || chars[0] > '9') return false;
        if (chars[0] == '-' && chars.length <= 1 || chars[1] == '0') return false;
        if (chars[0] == '0' && chars.length > 1) return false;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') return false;
        }
        return true;
    }


    public static int convert(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        if (!isValid(chars)) return 0;
        int minq = Integer.MIN_VALUE / 10;
        int minc = Integer.MIN_VALUE % 10;
        int res = 0;
        int num = 0;
        boolean posi = chars[0] != '-';
        for (int i = posi ? 0 : 1; i < chars.length; i++) {
            num = chars[i] - '0';
            if (res < minq || res == minq && num < minc) {
                return 0;
            }
            res = res * 10 + num;
        }

        if (posi && res == Integer.MIN_VALUE)
            return 0;
        return posi ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(convert("123"));
        System.out.println(convert("023"));
        System.out.println(convert("A13"));
        System.out.println(convert("2147483647"));
        System.out.println(convert("2147483648"));
        System.out.println(convert("-123"));
    }
}
