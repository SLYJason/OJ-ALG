package LeetCode.LC_201_400.LC252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution: sorting.
 */
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i=1; i<intervals.length; i++) {
            int[] prev = intervals[i-1];
            int[] cur = intervals[i];
            if (cur[0] < prev[1]) return false;
        }
        return true;
    }
}
