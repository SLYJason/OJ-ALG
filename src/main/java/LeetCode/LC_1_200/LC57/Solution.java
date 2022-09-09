package LeetCode.LC_1_200.LC57;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution: greedy.
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> list = new LinkedList<>();
        int i = 0;
        // step 1: add all intervals before newInterval, no overlap.
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        // step 2: merge overlap.
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        // step 3: add the rest.
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
