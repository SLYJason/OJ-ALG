package LeetCode.LC_201_400.LC240;

/**
 * Solution 1: search from top right.
 */
public class Solution_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
