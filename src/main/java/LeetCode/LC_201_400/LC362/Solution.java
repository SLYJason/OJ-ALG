package LeetCode.LC_201_400.LC362;

import java.util.Queue;
import java.util.LinkedList;
/**
 * Solution: queue.
 */
public class Solution {
    class HitCounter {
        Queue<Integer> queue;

        public HitCounter() {
            queue = new LinkedList<>();
        }

        public void hit(int timestamp) {
            queue.offer(timestamp);
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
