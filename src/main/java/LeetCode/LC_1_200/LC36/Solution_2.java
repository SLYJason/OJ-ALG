package LeetCode.LC_1_200.LC36;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: clean code, 1 pass.
 * For each value in Sudoku, it has 3 attributes:
 * 1. Its row attribute.
 * 2. Its column attribute.
 * 3. Its 3x3 block attribute.
 * Encode above 3 separately and check in 1 pass.
 */
public class Solution_2 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char num = board[i][j];
                if(num == '.') continue;
                String row = num + " in row: " + i;
                String col = num + " in col: " + j;
                String block = num + " in block: " + i/3 + ", " + j/3;
                if(set.contains(row) || set.contains(col) || set.contains(block)) return false;
                set.add(row);
                set.add(col);
                set.add(block);
            }
        }
        return true;
    }
}
