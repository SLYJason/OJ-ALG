package LeetCode.LC_1_200.LC121;

/**
 * Solution 2: DP.
 */
public class Solution_2 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int min_so_far = prices[0], max_profit = 0;
        for(int i=1; i<prices.length; i++) {
            min_so_far = Math.min(min_so_far, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_so_far);
        }
        return max_profit;
    }
}
