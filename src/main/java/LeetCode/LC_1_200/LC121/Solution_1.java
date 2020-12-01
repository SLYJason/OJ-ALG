package LeetCode.LC_1_200.LC121;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution 1: monotonic queue.
 */
public class Solution_1 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        Deque<Integer> queue = new LinkedList();
        queue.offer(prices[0]);
        int max_profit = 0;
        for(int i=1; i<prices.length; i++) {
            while(!queue.isEmpty() && queue.getLast() >= prices[i]) {
                queue.pollLast();
            }
            queue.offer(prices[i]);
            max_profit = Math.max(max_profit, queue.getLast() - queue.getFirst());
        }
        return max_profit;
    }
}
