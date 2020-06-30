package LeetCode.Search;

public class LeetCode79 {
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(search(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int r, int c, int index) {
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r > rows-1 || c > cols-1 || board[r][c] != word.charAt(index)) return false;
        char ch = board[r][c];
        board[r][c] = '*'; // '*' means this cell already visited
        boolean res = search(board, word, r, c+1, index+1) ||
                search(board, word, r+1, c, index+1) ||
                search(board, word, r, c-1, index+1) ||
                search(board, word, r-1, c, index+1);
        board[r][c] = ch; // recover this cell with original char
        return res;
    }
}
