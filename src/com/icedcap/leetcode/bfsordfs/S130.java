package com.icedcap.leetcode.bfsordfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. Surrounded Regions(M)
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class S130 {
        public void solve(char[][] board) {
            if (board.length == 0) return;

            int rowN = board.length;
            int colN = board[0].length;
            Queue<Point> queue = new LinkedList<Point>();

            //get all 'O's on the edge first
            for (int r = 0; r < rowN; r++) {
                if (board[r][0] == 'O') {
                    board[r][0] = '+';
                    queue.add(new Point(r, 0));
                }
                if (board[r][colN - 1] == 'O') {
                    board[r][colN - 1] = '+';
                    queue.add(new Point(r, colN - 1));
                }
            }

            for (int c = 0; c < colN; c++) {
                if (board[0][c] == 'O') {
                    board[0][c] = '+';
                    queue.add(new Point(0, c));
                }
                if (board[rowN - 1][c] == 'O') {
                    board[rowN - 1][c] = '+';
                    queue.add(new Point(rowN - 1, c));
                }
            }


            //BFS for the 'O's, and mark it as '+'
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int row = p.x;
                int col = p.y;
                if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                    board[row - 1][col] = '+';
                    queue.add(new Point(row - 1, col));
                }
                if (row + 1 < rowN && board[row + 1][col] == 'O') {
                    board[row + 1][col] = '+';
                    queue.add(new Point(row + 1, col));
                }
                if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                    board[row][col - 1] = '+';
                    queue.add(new Point(row, col - 1));
                }
                if (col + 1 < colN && board[row][col + 1] == 'O') {
                    board[row][col + 1] = '+';
                    queue.add(new Point(row, col + 1));
                }
            }


            //turn all '+' to 'O', and 'O' to 'X'
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == '+') board[i][j] = 'O';
                }
            }
        }

        static class Point{
            int x;
            int y;

            public Point(int row, int col) {
                this.x = row;
                this.y = col;
            }
        }
}
