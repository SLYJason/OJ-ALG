package LeetCode.LC_1_200.LC73;

/**
 * Solution 2: constant space.
 */
public class Solution_2 {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean row0 = false, col0 = false;
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(matrix[r][c] == 0) {
                    if(r == 0) row0 = true;
                    if(c == 0) col0 = true;
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        // set row and column except 1st row and column.
        for(int r=1; r<rows; r++) {
            for(int c=1; c<cols; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) matrix[r][c] = 0;
            }
        }

        // set 1st row.
        if(row0) {
            for(int c=0; c<cols; c++) matrix[0][c] = 0;
        }

        // set 1st column.
        if(col0) {
            for(int r=0; r<rows; r++) matrix[r][0] = 0;
        }
    }
}
