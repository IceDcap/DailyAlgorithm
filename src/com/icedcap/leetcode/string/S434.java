package com.icedcap.leetcode.string;

/**
 * 434. Number of Segments in a String(E)
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class S434 {
    public int countSegments(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) result++;
        }
        return result;
    }


    public int countSegments1(String s) {
        String trimed = s.trim();
        //正则"\\s"表示空格回车换行等空白符，"+"表示一个或者多个这样的空白符
        return trimed.split("\\s+").length;
    }

    public static void main(String[] args) {
        System.out.println(new S434().countSegments1("Hello, my name is John"));
    }
}
