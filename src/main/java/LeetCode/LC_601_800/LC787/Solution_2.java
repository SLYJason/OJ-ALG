package LeetCode.LC_601_800.LC787;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Solution 2: dijkstra algorithm.
 */
public class Solution_2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // build graph.
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] f : flights) graph.get(f[0]).add(new int[]{f[1], f[2]});
        // Dijkstra algorithm.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0}); // entry: [city, price, stops].
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int city = cur[0];
            int price = cur[1];
            int stops = cur[2];
            if(city == dst) return price; // stop early.
            if(stops <= K) {
                List<int[]> edges = graph.get(city);
                for(int[] edge : edges) {
                    int next_city = edge[0], next_price = edge[1];
                    int newPrice = price + next_price;
                    pq.offer(new int[]{next_city, newPrice, stops + 1});
                }
            }
        }
        return -1;
    }
}
