package LeetCode.LC_801_1000.LC973;

import java.util.Arrays;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOf(points, K);
    }
}
