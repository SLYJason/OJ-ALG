package LeetCode.LC_1601_1800.LC1753;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution 1: PriorityQueue.
 */
public class Solution_1 {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        int score = 0;
        while(pq.size() >= 2) {
            int p1 = pq.poll();
            int p2 = pq.poll();
            if(--p1 > 0) {
                pq.offer(p1);
            }
            if(--p2 > 0) {
                pq.offer(p2);
            }
            score++;
        }
        return score;
    }
}
