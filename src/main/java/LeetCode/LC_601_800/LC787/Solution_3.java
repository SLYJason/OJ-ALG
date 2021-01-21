package LeetCode.LC_601_800.LC787;

import java.util.Arrays;

/**
 * Solution 3: Bellman-Ford (DP).
 */
public class Solution_3 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        for(int i=0; i<=K; i++) {
            int[] temp = Arrays.copyOf(costs, n);
            for(int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if(costs[u] == Integer.MAX_VALUE) continue;
                if(costs[u] + w < temp[v]) {
                    temp[v] = costs[u] + w;
                }
            }
            costs = temp;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
