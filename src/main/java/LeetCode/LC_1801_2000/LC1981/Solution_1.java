package LeetCode.LC_1801_2000.LC1981;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force - TLE.
 */
public class Solution_1 {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> sums = new HashSet<>() {
            {
                add(0);
            }
        };
        // step 1: calculate all possible sums from every row.
        for (int[] row : mat) {
            Set<Integer> tmp = new HashSet<>();
            for (int n : row) {
                for (int sum : sums) {
                    tmp.add(sum + n);
                }
            }
            sums = new HashSet<>(tmp);
        }
        // step 2: get the minimum absolute difference.
        int res = Integer.MAX_VALUE;
        for (int sum : sums) {
            res = Math.min(res, Math.abs(sum - target));
        }
        return res;
    }
}
