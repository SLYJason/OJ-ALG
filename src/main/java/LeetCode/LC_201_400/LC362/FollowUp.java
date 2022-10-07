package LeetCode.LC_201_400.LC362;

import java.util.Queue;
import java.util.LinkedList;
/**
 * Follow Up: queue
 */
public class FollowUp {
    class HitCounter {
        Queue<Hit> queue;
        int count;

        public HitCounter() {
            queue = new LinkedList<>();
            count = 0;
        }

        public void hit(int timestamp) {
            if (queue.isEmpty()) {
                queue.offer(new Hit(timestamp, 1));
                count = 1;
                return;
            }
            Hit hit = queue.peek();
            if (hit.timestamp == timestamp) {
                hit.hits++;
            } else {
                queue.offer(new Hit(timestamp, 1));
            }
            count++;
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty() && queue.peek().timestamp <= timestamp - 300) {
                count -= queue.poll().hits;
            }
            return count;
        }

        class Hit {
            int timestamp;
            int hits;

            Hit(int timestamp, int hits) {
                this.timestamp = timestamp;
                this.hits = hits;
            }
        }
    }
}
