package LeetCode.LC_1201_1400.LC1337;

/**
 * Solution 3: vertical traversal.
 */
public class Solution_3 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[k];
        int i = 0;
        for(int c=0; c<n && i<k; c++) {
            for(int r=0; r<m && i<k; r++) {
                if(mat[r][c] == 0 && (c == 0 || mat[r][c-1] == 1)) {
                    res[i++] = r;
                }
            }
        }
        // if there has not enough weakest rows, it's because some of the first k weakest rows are entirely 1. In this case, include these rows' lowest row index.
        for(int r=0; i<k; r++) {
            if(mat[r][n-1] == 1) {
                res[i++] = r;
            }
        }
        return res;
    }
}
