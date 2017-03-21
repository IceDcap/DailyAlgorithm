package com.icedcap.leetcode.math;

/**
 * 174. Dungeon Game(H)
 * <p>
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * <p>
 * <p>
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * Notes:
 * <p>
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class S174 {
    //dp
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 ||
                dungeon[0] == null || dungeon[0].length == 0) return 1;
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row--][column--];
        dp[row][column] = dungeon[row][column] > 0 ? 1 : -dungeon[row][column] + 1;
//        for (int j = column - 1; j >= 0; j--) {
//            dp[row][j] = Math.max(dp[row][j + 1] - dungeon[row][j], 1);
//        }

        for (int i = row - 1; i >= 0; i--) {
            dp[i][column] = Math.max(dp[i + 1][column] - dungeon[i][column], 1);
            for (int j = column - 1; j >= 0; j--) {
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[0][0];
    }

    public static void main(String args[]) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(new S174().calculateMinimumHP(dungeon));
    }
}
