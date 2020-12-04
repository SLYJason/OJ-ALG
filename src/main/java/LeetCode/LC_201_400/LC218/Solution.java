package LeetCode.LC_201_400.LC218;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * Solution: sweep line.
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList();
        List<int[]> heights = new ArrayList();
        // Step 1: transform + sorting.
        for(int[] b : buildings) {
            int[] left_h = new int[]{b[0], -b[2]}; // -h means the left side of building.
            int[] right_h = new int[]{b[1], b[2]}; // h means the right side of building.
            heights.add(left_h);
            heights.add(right_h);
        }
        Collections.sort(heights, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // Step 2: sweep line.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max-heap.
        pq.offer(0); // 0 is base key point.
        int prevMax = 0;
        for(int[] h : heights) {
            if(h[1] < 0) {
                pq.offer(-h[1]); // entering a building.
            } else {
                pq.remove(h[1]); // leaving a building.
            }

            int curMax = pq.peek();
            if(curMax != prevMax) { // encounter a new height, so it is a new key point.
                res.add(Arrays.asList(h[0], curMax));
                prevMax = curMax;
            }
        }
        return res;
    }
}
