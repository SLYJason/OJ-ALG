package LeetCode.LC_1201_1400.LC1329;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution 2: sort diagonals one by one.
 */
public class Solution_2 {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] sorted = new int[rows][cols];
        // sort all diagonals in the lower left corner.
        for(int r=0; r<rows; r++) {
            sortDiagonal(r, 0, mat, sorted);
        }
        // sort all diagonals in the upper right corner.
        for(int c=0; c<cols; c++) {
            sortDiagonal(0, c, mat, sorted);
        }
        return sorted;
    }

    private void sortDiagonal(int i, int j, int[][] mat, int[][] sorted) {
        int rows = mat.length, cols = mat[0].length;
        List<Integer> diagonal = new ArrayList<>();
        while(i < rows && j < cols) {
            diagonal.add(mat[i++][j++]);
        }
        Collections.sort(diagonal);
        while(i > 0 && j > 0) {
            sorted[--i][--j] = diagonal.remove(diagonal.size() - 1);
        }
    }
}
