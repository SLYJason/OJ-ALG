package LeetCode.Array;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Solution: sorting each interval start index.
 * Time Complexity: O(n log(n)).
 * Space Complexity: O(1).
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        List<int[]> list = new LinkedList();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int[] curr = intervals[0];
        for(int[] interval : intervals) {
            if(interval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                list.add(curr);
                curr = interval;
            }
        }
        list.add(curr);
        return list.toArray(new int[list.size()][2]);
    }
}
