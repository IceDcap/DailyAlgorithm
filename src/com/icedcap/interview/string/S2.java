package com.icedcap.interview.string;

/**
 * 字符串中数字子串求和
 * A-1B--2C--D6E
 * A1CD2E33
 * A-1BC--12
 * A1.3
 */
public class S2 {

    public static int sumOfString(String str) {
        if (str == null) return 0;
        int num = 0, res = 0;
        boolean posi = true;
        for (int i = 0; i < str.length(); i++) {
            int ch = (int) str.charAt(i) - '0';
            if (ch < 0 || ch > 9) {
                res += num;
                num = 0;
                if (str.charAt(i) == '-') {
                    posi = !posi;
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? ch : -ch);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumOfString("A-1B--2C--D6E"));
        System.out.println(sumOfString("A1CD2E33"));
        System.out.println(sumOfString("A-1BC--12"));
        System.out.println(sumOfString("A1.3"));
        char[] nums = {'1',0,0,0,'2',0,'3'};
        System.out.println(String.valueOf(nums));
    }
}
