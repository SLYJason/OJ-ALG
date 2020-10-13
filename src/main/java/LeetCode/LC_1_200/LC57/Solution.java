package LeetCode.LC_1_200.LC57;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};
        List<int[]> merged = new ArrayList();
        int i=0;
        // step 1: add all intervals before newInterval, no overlap.
        while(i<intervals.length && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i++]);
        }
        // step 2: merge overlap.
        while(i<intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval);
        // step 3: add all intervals after the newInterval, no overlap.
        while(i<intervals.length && newInterval[1] < intervals[i][0]) {
            merged.add(intervals[i++]);
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
