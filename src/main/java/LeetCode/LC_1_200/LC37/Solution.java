package LeetCode.LC_1_200.LC37;

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){ //trial: try 1 through 9.
                        if(isValid(board, i, j, k)) { // need to check constraints before fill the cell.
                            board[i][j] = k;
                            if(solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        int boxRow = r/3*3, boxCol = c/3*3;
        for(int i=0; i<9; i++) {
            if(board[r][i] == ch) return false; // check row.
            if(board[i][c] == ch) return false; // check column.
            if(board[boxRow + i/3][boxCol + i%3] == ch) return false; // check each box.
        }
        return true;
    }
}