package LeetCode.LC_401_600.LC322;

import java.util.Arrays;

public class Solution_1 {
    // Solution 1: Bottom up DP
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for(int i=0; i<count.length; i++) {
            for(int coin : coins) {
                if(coin <= i && count[i-coin] != Integer.MAX_VALUE) {
                    count[i] = Math.min(count[i], count[i-coin]+1);
                }
            }
        }
        return count[amount] == Integer.MAX_VALUE ? -1 : count[amount];
    }
}
