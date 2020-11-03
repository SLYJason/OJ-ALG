package LeetCode.LC_1_200.LC79;

/**
 * Solution: DFS.
 */
public class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r > board.length-1 || c > board[0].length-1 || board[r][c] != word.charAt(index)) return false;
        char ch = board[r][c];
        board[r][c] = '*'; // '*' means this cell already visited
        boolean res = false;
        for(int[] dir : dirs) {
            int nx = r + dir[0];
            int ny = c + dir[1];
            res = res || dfs(board, word, nx, ny, index+1);
        }
        board[r][c] = ch; // recover this cell with original char
        return res;
    }
}
