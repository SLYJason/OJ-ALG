package LeetCode.LC_1_200.LC85;

public class Solution_1 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max_area = 0;
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(matrix[r][c] == '1') {
                    dp[r][c] = c == 0 ? 1 : dp[r][c-1] + 1; // update the maxium length.

                    int min_length = dp[r][c];
                    // from current point, go upwards to find minimum length and update max_area accordingly.
                    for(int i=r; i>=0; i--) {
                        min_length = Math.min(min_length, dp[i][c]);
                        max_area = Math.max(max_area, min_length * (r-i+1));
                    }
                }
            }
        }
        return max_area;
    }
}
