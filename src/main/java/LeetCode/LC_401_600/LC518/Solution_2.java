package LeetCode.LC_401_600.LC518;

/**
 * Solution 2: 1D DP.
 */
public class Solution_2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
