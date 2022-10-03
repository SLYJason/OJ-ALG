package LeetCode.LC_201_400.LC322;

/**
 * Solution 2: top-down dp.
 */
public class Solution_2 {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount] != 0) return count[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount];
    }
}
