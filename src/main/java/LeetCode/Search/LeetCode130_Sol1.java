package LeetCode.Search;

public class LeetCode130_Sol1 {
    // Solution 1: DFS
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        // For cell in border, do DFS
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(i == 0 || i == rows-1 || j == 0 || j == cols-1) {
                    dfs(board, i, j, rows, cols);
                }
            }
        }
        // flip remaining 'O'(not connected to the border) to 'X', then flip '*' to 'O'
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int row, int col, int rows, int cols) {
        if(board[row][col] != 'O') return;
        // For any 'O' connected to the border, mark as '*'
        board[row][col] = '*';
        if(col < cols-1) {
            dfs(board, row, col+1, rows, cols);
        }
        if(row < rows-1) {
            dfs(board, row+1, col, rows, cols);
        }
        if(col > 0) {
            dfs(board, row, col-1, rows, cols);
        }
        if(row > 0) {
            dfs(board, row-1, col, rows, cols);
        }
    }
}
