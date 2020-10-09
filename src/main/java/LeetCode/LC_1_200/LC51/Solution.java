package LeetCode.LC_1_200.LC51;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution: backtrack, fill each row one by one. It can also be filled by column one by one.
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        char[][] board = new char[n][n];
        for(char[] arr : board) Arrays.fill(arr, '.');
        solve(0, n, board, res);
        return res;
    }

    private void solve(int r, int n, char[][] board, List<List<String>> res) {
        if(r == n) {
            build(n, board, res); // find a solution.
            return;
        }
        for(int i=0; i<n; i++) { // For current row, try to fill Q at each column position.
            if(isValid(n, board, r, i)) {
                board[r][i] = 'Q';
                solve(r+1, n, board, res);
                board[r][i] = '.';
            }
        }
    }


    // diagonal / slope: r-i = c-j.
    // diagonal \ slope: r-i = -1*(c-j).
    private boolean isValid(int n, char[][] board, int r, int c) {
        for(int i=0; i<r; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'Q' && (j == c || r-i == c-j || r-i == j-c)) return false;
            }
        }
        return true;
    }

    private void build(int n, char[][] board, List<List<String>> res) {
        List<String> list = new ArrayList();
        for(int i=0; i<n; i++) {
            list.add(new String(board[i]));
        }
        res.add(list);
    }
}
