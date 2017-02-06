package com.icedcap;

/**
 * Created by doushuqi on 16-12-28.
 */
public class Solution {

    public int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        boolean flag = false;
        long result = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if (c == '-') flag = true;
                else if (c == '+') flag = false;
                else if (!(c >= '0' && c <= '9')) return 0;
                continue;
            }
            if (i > 0 && !(c >= '0' && c <= '9')) {
                return 0;
            }
            int code = Integer.decode(String.valueOf(c));
            result = code * (long) Math.pow(10, (length - i - 1)) + result;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return flag ? (int) -result : (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("+-2"));
    }
}
