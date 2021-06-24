package LeetCode.LC_1001_1200.LC1182;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution 2: two way scan.
 */
public class Solution_2 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length, max = Integer.MAX_VALUE;
        int[] leftMost = {-1, -1, -1, -1};
        int[] rightMost = {n, n, n, n};
        int[][] dist = new int[4][n];
        for(int i=0; i<4; i++) Arrays.fill(dist[i], -1);
        // move from left -> right.
        for(int i = 0; i < n; i++) {
            int color = colors[i];
            leftMost[color] = i;
            for(int j = 1; j <= 3; j++) {
                if(leftMost[j] != -1) {
                    dist[j][i] = i - leftMost[j];
                } else {
                    dist[j][i] = -1;
                }
            }
        }
        // move from right -> left.
        for(int i = n - 1; i >= 0; i--) {
            int color = colors[i];
            rightMost[color] = i;
            for(int j = 1; j < 4; j++) {
                if(rightMost[j] != n) {
                    if(dist[j][i] != -1) {
                        dist[j][i] = Math.min(dist[j][i], rightMost[j] - i);
                    } else {
                        dist[j][i] = rightMost[j] - i;
                    }
                }
            }
        }
        // execute the queries.
        List<Integer> res = new ArrayList<>();
        for(int[] q : queries) {
            res.add(dist[q[1]][q[0]]);
        }
        return res;
    }
}
