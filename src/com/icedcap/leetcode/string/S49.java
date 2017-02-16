package com.icedcap.leetcode.string;

import java.util.*;

/**
 * 49. Group Anagrams(M)
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class S49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> container = new HashMap<>();
        List<String> strList = Arrays.asList(strs);
        for (String item : strList) {
            char[] ch = item.toCharArray();
            Arrays.sort(ch);
            String strKey = String.valueOf(ch);
            if (!container.containsKey(strKey)) {
                List<String> member = new ArrayList<>();
                member.add(item);
                container.put(strKey, member);
            } else {
                container.get(strKey).add(item);
            }

        }
        return new ArrayList<List<String>>(container.values());
    }

    public static void main(String[] args) {
        String[] arg = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new S49().groupAnagrams(arg);
        for (List<String> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
