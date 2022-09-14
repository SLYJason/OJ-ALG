package LeetCode.LC_401_600.LC552;

/**
 * Solution 2: DP.
 */
public class Solution_2 {

    public int checkRecord(int n) {
        // step 1: string without `A`.
        long mod = 1_000_000_007;
        long[] dp = new long[n <= 3 ? 4 : n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7; // it comes from 2 * 2 * 2 - 1 ('LLL') = 7;
        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] % mod + (mod - dp[i - 4]) % mod; // the original is dp[i] = (2 * dp[i - 1] - dp[i -4]) % mod, but it can get negative value to do the mod, so we can not use it.
        }
        long sum = dp[n];
        // step 2: string with `A`.
        for (int i = 1; i <= n; i++) {
            sum += (dp[i - 1] * dp[n - i]) % mod;
        }
        return (int)(sum % mod);
    }
}
