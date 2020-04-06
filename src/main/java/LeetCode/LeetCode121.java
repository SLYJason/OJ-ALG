package LeetCode;

public class LeetCode121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int minPrice = prices[0], maxPrice = 0;
        for(int i=1; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPrice = Math.max(maxPrice, prices[i] - minPrice);
        }
        return maxPrice;
    }
}
