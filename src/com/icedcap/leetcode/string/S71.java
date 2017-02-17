package com.icedcap.leetcode.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * 71. Simplify Path(M)
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class S71 {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> container = new Stack<>();
        for (String s : strs) {
            if (s.equals("..")) {
                if (!container.empty()) {
                    container.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                container.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String str : container) {
            stack.push(str);
        }
        for (String str : stack) {
            sb.append("/");
            sb.append(str);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }


    public static void main(String[] args) {
//        String path = "/a/./b/../../c/";
//        String path = "/home/../../..";
        String path = "/abc/...";
        String newPath = new S71().simplifyPath(path);
        System.out.println(newPath);
    }
}
