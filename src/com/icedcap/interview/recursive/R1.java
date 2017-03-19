package com.icedcap.interview.recursive;

/**
 * 返回斐波那契数列的第n项以及相关问题
 */
public class R1 {

    //O(2^n)
    public static int f1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return f1(n - 1) + f1(n - 2);
    }



    //O(n)
    public static int f2(int n) {
        if (n<1) {
            return 0;
        }
        if (n==1||n==2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = res;
            res = res +pre;
            pre = tmp;
        }
        return res;
    }




    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        System.out.println(f1(30));
        System.out.println("code running time: " + (System.currentTimeMillis()-cur));
    }
    //给定一个整数N，代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法
}
