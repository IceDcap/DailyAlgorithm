package com.icedcap.leetcode.string;

/**
 * 43. Multiply Strings(M)
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class S43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int tmp = n1 * n2 + result[i + j + 1];
                result[i + j] += tmp / 10;
                result[i + j + 1] = tmp % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < result.length; k++) {
            if (k == 0 && result[k] == 0) continue;
            sb.append(result[k]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new S43().multiply("120", "27"));
    }
}
