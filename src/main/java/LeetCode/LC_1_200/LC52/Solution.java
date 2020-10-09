package LeetCode.LC_1_200.LC52;

public class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        boolean[] veritical = new boolean[n];
        boolean[] diag_1 = new boolean[2*n-1]; // red diagonal, with slope 1.
        boolean[] diag_2 = new boolean[2*n-1]; // blue diagonal, with slope -1.
        solve(0, n, veritical, diag_1, diag_2);
        return res;
    }

    private void solve(int row, int n, boolean[] veritical, boolean[] diag_1, boolean[] diag_2) {
        if(row == n) {
            res++;
            return;
        }
        for(int col=0; col<n; col++) {
            if(veritical[col] || diag_1[row+col] || diag_2[row-col+n-1]) continue;
            veritical[col] = true;
            diag_1[row+col] = true;
            diag_2[row-col+n-1] = true;

            solve(row+1, n, veritical, diag_1, diag_2);

            veritical[col] = false;
            diag_1[row+col] = false;
            diag_2[row-col+n-1] = false;
        }
    }
}
