package LeetCode.LC_1_200.LC122;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution 1: monotonic queue.
 */
public class Solution_1 {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        Deque<Integer> deque = new LinkedList();
        deque.offer(prices[0]);
        for(int i=1; i<prices.length; i++) {
            if(!deque.isEmpty() && deque.getLast() > prices[i]) {
                max_profit += deque.getLast() - deque.getFirst();
                deque.clear();
            }
            deque.offer(prices[i]);
        }
        if(!deque.isEmpty()) max_profit += deque.getLast() - deque.getFirst();
        return max_profit;
    }
}
