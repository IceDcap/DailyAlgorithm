package com.icedcap.leetcode.string;

/**
 * 67. Add Binary(E)
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class S67 {

    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int sign = 0;
        int x = a.length() - 1, y = b.length() - 1;
        while (x >= 0 || y >= 0) {
            if (x >= 0) {
                sign += a.charAt(x) - '0';
                x--;
            }
            if (y >= 0) {
                sign += b.charAt(y) - '0';
                y--;
            }
            s.append(sign % 2);
            sign >>= 1;
        }
        if (sign!=0){
            s.append(sign);
        }

        return s.reverse().toString();
    }
}
