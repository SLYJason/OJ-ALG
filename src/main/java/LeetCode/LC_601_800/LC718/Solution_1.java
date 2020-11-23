package LeetCode.LC_601_800.LC718;

/**
 * Solution 1: DP.
 */
public class Solution_1 {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        int max_length = 0;
        for(int i=1; i<A.length+1; i++) {
            for(int j=1; j<B.length+1; j++) {
                dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0;
                max_length = Math.max(max_length, dp[i][j]);
            }
        }
        return max_length;
    }
}
