package LeetCode.LC_401_600.LC593;

import java.util.Arrays;

/**
 * Solution: sorting + verify.
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        // verify side and diagonal lengths.
        double s1 = getDistance(points[0], points[1]);
        double s2 = getDistance(points[0], points[2]);
        double s3 = getDistance(points[3], points[1]);
        double s4 = getDistance(points[3], points[2]);
        double d1 = getDistance(points[0], points[3]);
        double d2 = getDistance(points[1], points[2]);
        return s1 != 0 && s1 == s2 && s2 == s3 && s3 == s4 && d1 == d2;
    }

    private double getDistance(int[] p1, int [] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }
}
