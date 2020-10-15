package LeetCode.LC_201_400.LC348;

/**
 * Solution 2: optimal solution.
 * Time Complexity: O(N).
 * Space Complexity: O(N).
 */
public class Solution_2 {
    class TicTacToe {
        int n;
        int[] rows;
        int[] cols;
        int diag1;
        int diag2;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
            diag1 = 0;
            diag2 = 0;
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
            int add = player == 1 ? 1 : -1;
            rows[row] += add;
            cols[col] += add;
            if(row == col) diag1 += add;
            if(row + col == n-1) diag2 += add;
            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n) return player;
            return 0;
        }
    }
}
