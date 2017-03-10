package com.icedcap.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal(M)
 * <p>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class S166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        //判断正负号
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        //整数部分
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        S166 instance = new S166();
//        System.out.println(instance.fractionToDecimal(1, 2));
//        System.out.println(instance.fractionToDecimal(2, 1));
//        System.out.println(instance.fractionToDecimal(2, 3));
        System.out.println(instance.fractionToDecimal(-1, -2147483648));
    }
}
