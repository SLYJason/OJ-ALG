package LeetCode.LC_1_200.LC149;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;
        int res = 0;
        for(int i=0; i<points.length; i++) {
            Map<String, Integer> map = new HashMap(); // K: slope, V: # of points has this slope.
            int same_points = 1;
            int max_points = 0;
            int[] p1 = points[i];
            int x1 = p1[0], y1 = p1[1];
            for(int j=i+1; j<points.length; j++) {
                int[] p2 = points[j];
                int x2 = p2[0], y2 = p2[1];
                if(x1 == x2 && y1 == y2) {
                    same_points++; // duplicate points.
                } else {
                    String slope = getSlope(p1, p2);
                    map.put(slope, map.getOrDefault(slope, 0)+1);
                    max_points = Math.max(max_points, map.get(slope));
                }
            }
            res = Math.max(res, max_points + same_points);
        }
        return res;
    }

    // slope String representation: dy_dx.
    private String getSlope(int[] p1, int[] p2) {
        StringBuilder slope = new StringBuilder();
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        // vertical line
        if(dx == 0) slope.append(0).append("_").append(p1[0]);
        // horizontal line
        if(dy == 0) slope.append(p1[1]).append("_").append(0);
        if(dx != 0 && dy != 0) {
            int gcd = gcd(dx, dy);
            slope.append(dy/gcd).append("_").append(dx/gcd);
        }
        return slope.toString();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
