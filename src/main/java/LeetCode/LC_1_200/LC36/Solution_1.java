package LeetCode.LC_1_200.LC36;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force, 3 pass.
 */
public class Solution_1 {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length, cols = board[0].length;
        if(rows != 9 || cols != 9) return false;
        // 1. check each row.
        for(int i=0; i<rows; i++) {
            Set<Character> set = new HashSet();
            for(int j=0; j<cols; j++) {
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        // 2. check each column.
        for(int i=0; i<cols; i++) {
            Set<Character> set = new HashSet();
            for(int j=0; j<rows; j++) {
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        // 3. check 3*3 sub box
        for(int i=0; i<rows; i += 3) {
            for(int j=0; j<cols; j += 3) {
                // check 3*3 sub box row.
                Set<Character> set = new HashSet();
                for(int m=i; m<i+3; m++) {
                    for(int n=j; n<j+3; n++) {
                        if(board[m][n] == '.') continue;
                        if(set.contains(board[m][n])) return false;
                        set.add(board[m][n]);
                    }
                }
            }
        }
        return true;
    }
}
