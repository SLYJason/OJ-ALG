package LeetCode.LC_201_400.LC304;

/**
 * Solution: DP.
 */
public class Solution {
    class NumMatrix {
        int[][] dp;
        public NumMatrix(int[][] matrix) {
            if(matrix.length == 0) return;
            dp = new int[matrix.length+1][matrix[0].length+1];
            for(int i=1; i<=matrix.length; i++) {
                for(int j=1; j<=matrix[0].length; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
        }
    }
}
