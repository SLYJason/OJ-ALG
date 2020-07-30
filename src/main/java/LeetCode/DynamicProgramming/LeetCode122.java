package LeetCode.DynamicProgramming;

public class LeetCode122 {
    /**
     * Solution 1: keep finding valley and peak
     */
    public int maxProfit1(int[] prices) {
        int max_profit = 0, i = 0;
        int buy = prices[0], sell = prices[0];
        while(i < prices.length-1) {
            while(i < prices.length-1 && prices[i] >= prices[i+1]) i++;
            buy = prices[i];
            while(i < prices.length-1 && prices[i] <= prices[i+1]) i++;
            sell = prices[i];
            max_profit += sell - buy;
        }
        return max_profit;
    }

    /**
     * Solution 2: optimal solution
     */
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
