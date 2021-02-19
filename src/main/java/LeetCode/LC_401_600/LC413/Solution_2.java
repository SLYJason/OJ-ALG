package LeetCode.LC_401_600.LC413;

/**
 * Solution 2: DP.
 */
public class Solution_2 {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, count = 0;
        int[] dp = new int[n]; // dp[i] means the number of arithmetic slices ending with A[i].
        for(int i=2; i<n; i++) {
            if(A[i-1] - A[i-2] == A[i] - A[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            count += dp[i];
        }
        return count;
    }
}
