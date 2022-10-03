package LeetCode.LC_201_400.LC322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FollowUp {
    public static List<Integer> coinCombinations(int[] coins, int amount) {
        List<Integer> res = new ArrayList<>();
        if (amount <= 0) return res;

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
        // no valid combinations.
        if (dp[amount] == Integer.MAX_VALUE) {
            return res;
        }
        int rest = dp[amount];
        while (rest > 0) {
            for (int coin : coins) {
                if (amount - coin >= 0 && dp[amount - coin] == rest - 1) {
                    res.add(coin);
                    amount -= coin;
                    break;
                }
            }
            rest--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(coinCombinations(coins1, amount1));

        int[] coins2 = {2};
        int amount2 = 13;
        System.out.println(coinCombinations(coins2, amount2));

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(coinCombinations(coins3, amount3));

        int[] coins4 = {1, 2, 5};
        int amount4 = 18;
        System.out.println(coinCombinations(coins4, amount4));

        int[] coins5 = {1, 2, 3, 4};
        int amount5 = 22;
        System.out.println(coinCombinations(coins5, amount5));
    }
}
