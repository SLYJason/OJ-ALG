package LeetCode.LC_1_200.LC48;

/**
 * Solution 1: transpose + reverse column (left -> right).
 */
public class Solution_1 {
    public void rotate(int[][] matrix) {
        // transpose.
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse column (left -> right).
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j] = temp;
            }
        }
    }
}
