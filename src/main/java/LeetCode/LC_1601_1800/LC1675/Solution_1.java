package LeetCode.LC_1601_1800.LC1675;

import java.util.PriorityQueue;

/**
 * Solution 1: PriorityQueue.
 */
public class Solution_1 {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> b - a); // max heap.
        int min = Integer.MAX_VALUE;
        // double odd number and push every number into max heap.
        for(int n : nums) {
            int pushed = n % 2 == 0 ? n : n * 2;
            min = Math.min(min, pushed);
            max_heap.offer(pushed);
        }
        // decrease the maximum number to find the minimum deviation.
        int min_dev = max_heap.peek() - min;
        while(max_heap.peek() % 2 == 0) {
            int n = max_heap.poll();
            max_heap.offer(n / 2);
            min = Math.min(min, n / 2);
            min_dev = Math.min(min_dev, max_heap.peek() - min); // check minimum deviation.
        }
        return min_dev;
    }
}
