package LeetCode.LC_1201_1400.LC1244;

import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: using PriorityQueue.
 */
public class Solution_1 {
    class Leaderboard {
        Map<Integer, Integer> map; // K: playerId, V: score.
        public Leaderboard() {
            map = new HashMap();
        }

        // Time Complexity: O(1).
        public void addScore(int playerId, int score) {
            map.put(playerId, map.getOrDefault(playerId, 0) + score);
        }

        // Time Complexity: O(N * logN).
        public int top(int K) {
            PriorityQueue<Integer> pq = new PriorityQueue(); // min-heap.
            for(int score : map.values()) {
                pq.offer(score);
                if(pq.size() > K) pq.poll();
            }
            int topK = 0;
            while(!pq.isEmpty()) {
                int s = pq.poll();
                topK += s;
            }
            return topK;
        }

        // Time Complexity: O(1).
        public void reset(int playerId) {
            map.remove(playerId);
        }
    }
}
