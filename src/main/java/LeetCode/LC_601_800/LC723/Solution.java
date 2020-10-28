package LeetCode.LC_601_800.LC723;

public class Solution {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean[][] flag = new boolean[rows][cols]; // used to mark a candy can be crushed.
        while(crush(board, flag)) {
            move(board);
        }
        return board;
    }

    private boolean crush(int[][] board, boolean[][] flag) {
        boolean canBeCrush = false;
        int rows = board.length, cols = board[0].length;
        // Step 1: mark candy can be crushed.
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(r-1 >= 0 && r+1 < rows && board[r][c] != 0 && board[r][c] == board[r-1][c] && board[r][c] == board[r+1][c]) {
                    flag[r-1][c] = true;
                    flag[r][c] = true;
                    flag[r+1][c] = true;
                    canBeCrush = true;
                }
                if(c-1 >= 0 && c+1 < cols && board[r][c] != 0 && board[r][c] == board[r][c-1] && board[r][c] == board[r][c+1]) {
                    flag[r][c-1] = true;
                    flag[r][c] = true;
                    flag[r][c+1] = true;
                    canBeCrush = true;
                }
            }
        }
        // Step 2: crush flagged candy.
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(flag[r][c]) {
                    board[r][c] = 0;
                    flag[r][c] = false;
                }
            }
        }
        return canBeCrush;
    }

    // move each column elements to the 0.
    private void move(int[][] board) {
        for(int c=0; c<board[0].length; c++) {
            int ri=board.length-1;
            while(ri >= 0) { // using two-pointers logic here.
                int rj = ri;
                while(rj > 0 && board[rj][c] == 0) rj--;
                swap(board, ri, c, rj, c);
                ri--;
            }
        }
    }

    private void swap(int[][] board, int a1, int a2, int b1, int b2) {
        int temp = board[a1][a2];
        board[a1][a2] = board[b1][b2];
        board[b1][b2] = temp;
    }
}
