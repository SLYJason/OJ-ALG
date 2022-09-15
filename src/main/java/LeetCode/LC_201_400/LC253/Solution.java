package LeetCode.LC_201_400.LC253;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution: PriorityQueue
 */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1) return intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min-heap
        minHeap.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(end);
        }
        return minHeap.size();
    }
}
