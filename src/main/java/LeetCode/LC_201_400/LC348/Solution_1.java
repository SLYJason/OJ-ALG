package LeetCode.LC_201_400.LC348;

import java.util.Arrays;

/**
 * Solution 1: brute-force.
 * Time Complexity: O(N^2).
 * Space Complexity: O(N).
 */
public class Solution_1 {
    class TicTacToe {
        int n;
        char[][] board;
        char x;
        char o;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.n = n;
            board = new char[n][n];
            for(char[] row : board) Arrays.fill(row, ' ');
            x = 'x';
            o = 'o';
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            board[row][col] = player == 1 ? x : o;
            return isWin(n, board) ? player : 0;
        }

        public boolean isWin(int n, char[][] board) {
            // check each row.
            for(int r=0; r<n; r++) {
                if(board[r][0] == ' ') continue;
                char ch = board[r][0];
                int c = 1;
                while(c < n && ch == board[r][c]) c++;
                if(c == n) return true;
            }
            // check each col.
            for(int c=0; c<n; c++) {
                if(board[0][c] == ' ') continue;
                char ch = board[0][c];
                int r = 1;
                while(r < n && ch == board[r][c]) r++;
                if(r == n) return true;
            }
            // check \ diagonal.
            char ch1 = board[0][0];
            if(ch1 != ' ') {
                int i=1;
                while(i < n && ch1 == board[i][i]) i++;
                if(i == n) return true;
            }
            // check / diagonal.
            char ch2 = board[n-1][0];
            if(ch2 != ' ') {
                int i=1;
                while(i < n && ch2 == board[n-i-1][i]) i++;
                System.out.println(i);
                if(i == n) return true;
            }
            return false;
        }
    }
}
