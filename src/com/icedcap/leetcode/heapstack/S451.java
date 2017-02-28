package com.icedcap.leetcode.heapstack;

import java.util.*;

/**
 * 451. Sort Characters By Frequency(M)
 * <p>
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class S451 {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Integer[] tmp = new Integer[map.size()];
        map.values().toArray(tmp);
        Arrays.sort(tmp);
        StringBuilder sb = new StringBuilder();

        for (int i : tmp) {
            char ch = getKeyByValue(map, i);
            while (i > 0) {
                sb.append(ch);
                i--;
            }
            map.put(ch, -1);
        }


        return sb.reverse().toString();
    }

    private char getKeyByValue(Map<Character, Integer> map, int val) {
        for (char c : map.keySet()) {
            if (map.get(c) == val) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new S451().frequencySort("Aabb"));
        System.out.println(new S451().frequencySort("tree"));
        System.out.println(new S451().frequencySort("cccaaa"));
    }
}
