package LeetCode.LC_1_200.LC48;

/**
 * Solution 2: reverse row (top -> down) + transpose.
 */
public class Solution_2 {
    public void rotate(int[][] matrix) {
        // reverse row (top -> down).
        for(int i=0; i<matrix.length/2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = tmp;
        }
        // transpose.
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
