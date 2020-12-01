package LeetCode.LC_1_200.LC122;

/**
 * Solution 2: two pointers.
 */
public class Solution_2 {
    public int maxProfit(int[] prices) {
        int max_profit = 0, buy = prices[0], sell = prices[0], i=1;
        while(i < prices.length) {
            while(i < prices.length && prices[i-1] >= prices[i]) i++;
            buy = prices[i-1];
            while(i < prices.length && prices[i-1] <= prices[i]) i++;
            sell = prices[i-1];
            max_profit += sell - buy;
        }
        return max_profit;
    }
}
