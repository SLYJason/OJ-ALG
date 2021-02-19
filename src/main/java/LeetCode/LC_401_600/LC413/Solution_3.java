package LeetCode.LC_401_600.LC413;

/**
 * Solution 3: DP, constant space.
 */
public class Solution_3 {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, count = 0, dp = 0;
        for(int i=2; i<n; i++) {
            if(A[i-1] - A[i-2] == A[i] - A[i-1]) {
                dp = dp + 1;
                count += dp;
            } else {
                dp = 0;
            }
        }
        return count;
    }
}
