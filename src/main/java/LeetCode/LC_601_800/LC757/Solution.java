package LeetCode.LC_601_800.LC757;

import java.util.Arrays;

/**
 * Solution: greedy.
 */
public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

        int second_largest = -1, largest = -1, res = 0;
        for (int[] interval : intervals) {
            if (interval[0] > largest) {
                second_largest = interval[1] - 1;
                largest = interval[1];
                res += 2;
            } else if (interval[0] > second_largest) {
                second_largest = largest;
                largest = interval[1];
                res++;
            }
        }
        return res;
    }
}
