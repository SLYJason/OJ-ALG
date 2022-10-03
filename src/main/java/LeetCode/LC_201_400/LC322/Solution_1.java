package LeetCode.LC_201_400.LC322;

import java.util.Arrays;

/**
 * Solution 1: bottom-up dp.
 */
public class Solution_1 {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i< dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
