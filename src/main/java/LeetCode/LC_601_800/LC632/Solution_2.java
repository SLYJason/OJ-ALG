package LeetCode.LC_601_800.LC632;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Solution 2: priority queue.
 */
public class Solution_2 {
    public int[] smallestRange(List<List<Integer>> nums) {
        // step 1: init
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; // min: max value in the PriorityQueue, max: max value in the PriorityQueue.
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            pq.offer(new Element(i, 0, list.get(0)));
            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(0));
        }

        // step 2: find the smallest range.
        int start = -1, end = -1, range = max - min + 1; // start: smallest range start index, end: smallest range end index, range: smallest range.
        while (pq.size() == nums.size()) {
            Element cur = pq.poll();
            int num = cur.num, idx = cur.idx, val = cur.val;
            if (max - val < range) { // find a smaller range so update it.
                range = max - val;
                start = val;
                end = max;
            }
            if (idx + 1 < nums.get(num).size()) {
                int new_val = nums.get(num).get(idx + 1);
                pq.offer(new Element(num, idx + 1, new_val));
                if (new_val > max) {
                    max = new_val;
                }
            }

        }
        return new int[]{start, end};
    }

    class Element {
        int num;
        int idx;
        int val;
        Element (int num, int idx, int val) {
            this.num = num;
            this.idx = idx;
            this.val = val;
        }
    }
}
