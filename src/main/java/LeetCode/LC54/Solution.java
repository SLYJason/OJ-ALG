package LeetCode.LC54;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution: brute force.
 * Start from: right -> down -> left -> top, we turn direction when we face the boundary or the element has been visited.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList();
        List<Integer> res = new ArrayList();
        int rows = matrix.length, cols = matrix[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        boolean[][] visited = new boolean[rows][cols];
        int r = 0, c = 0;
        for(int i=0; i<rows * cols; i++) {
            res.add(matrix[r][c]);
            visited[r][c] = true;
            int rn = r + directions[d][0];
            int cn = c + directions[d][1];
            if(rn < 0 || rn >= rows || cn < 0 || cn >= cols || visited[rn][cn]) {
                d = ++d == 4 ? 0 : d;
                r += directions[d][0];
                c += directions[d][1];;
            } else {
                r = rn;
                c = cn;
            }
        }
        return res;
    }
}
