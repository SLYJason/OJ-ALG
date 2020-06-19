package LeetCode.Search;

import java.util.Queue;
import java.util.LinkedList;

public class LeetCode130_Sol2 {
    // Solution 1: BFS
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(i == 0 || i == rows-1 || j == 0 || j == cols-1) {
                    bfs(board, i, j, rows, cols);
                }
            }
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int row, int col, int rows, int cols) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{row, col});
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            if(board[cell[0]][cell[1]] != 'O') continue;
            board[cell[0]][cell[1]] = '*';
            if(cell[1] < cols-1) {
                queue.add(new int[]{cell[0], cell[1]+1});
            }
            if(cell[0] < rows-1) {
                queue.add(new int[]{cell[0]+1, cell[1]});
            }
            if(cell[1] > 0) {
                queue.add(new int[]{cell[0], cell[1]-1});
            }
            if(cell[0] > 0) {
                queue.add(new int[]{cell[0]-1, cell[1]});
            }
        }
    }
}
