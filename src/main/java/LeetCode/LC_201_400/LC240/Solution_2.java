package LeetCode.LC_201_400.LC240;

/**
 * Solution 2: search from bottom left.
 */
public class Solution_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
