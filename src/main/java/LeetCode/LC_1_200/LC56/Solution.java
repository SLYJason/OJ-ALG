package LeetCode.LC_1_200.LC56;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Comparator;

/**
 * Solution: sorting + merge.
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            int[] lastInterval = list.getLast();
            int lastEnd = lastInterval[1];
            if (curStart <= lastEnd && curEnd > lastEnd) {
                lastInterval[1] = curEnd; // it means: ---curStart---lastEnd---curEnd---, should change the last interval end.
            } else if (curStart > lastEnd) {
                list.add(intervals[i]); // it means: ---lastEnd---curStart---, should append the new interval
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
