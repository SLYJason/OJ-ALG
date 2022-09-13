package LeetCode.LC_1801_2000.LC1981;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: Sorting + Prune.
 */
public class Solution_2 {
    public int minimizeTheDifference(int[][] mat, int target) {
        int min = 0, max = 0;
        for (int[] row : mat) {
            Arrays.sort(row);
            min += row[0];
            max += row[row.length - 1];
        }
        if (target <= min) return Math.abs(target - min); // base case 1.
        if (target >= max) return Math.abs(target - max); // base case 2.

        Set<Integer> sums = new HashSet<>() {
            {
                add(0);
            }
        };
        for (int[] row : mat) {
            Set<Integer> temp = new HashSet<>();
            for (int sum : sums) {
                for (int n : row) {
                    temp.add(sum + n);
                    if (sum + n > target) break; // exit the loop earlier.
                }
            }
            sums = temp;
        }
        int res = Integer.MAX_VALUE;
        for (int sum : sums) {
            res = Math.min(res, Math.abs(sum - target));
        }
        return res;
    }
}
