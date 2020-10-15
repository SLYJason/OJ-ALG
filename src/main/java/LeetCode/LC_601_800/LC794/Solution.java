package LeetCode.LC_601_800.LC794;

/**
 * Solution: using same logic in LC348.
 */
public class Solution {
    public boolean validTicTacToe(String[] board) {
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag1 = 0;
        int diag2 = 0;
        boolean xWin = false;
        boolean oWin = false;
        int turns = 0; // O means X move, 1 means O move.
        for(int r=0; r<n; r++) {
            String row = board[r];
            for(int c=0; c<n; c++) {
                char ch = row.charAt(c);
                if(ch == 'X') {
                    turns++;
                    rows[r]++;
                    cols[c]++;
                    if(r == c) diag1++;
                    if(r + c == n - 1) diag2++;
                }
                if(ch == 'O') {
                    turns--;
                    rows[r]--;
                    cols[c]--;
                    if(r == c) diag1--;
                    if(r + c == n - 1) diag2--;
                }

            }
        }
        for(int i=0; i<n; i++) {
            xWin = xWin ||  rows[i] == n || cols[i] == n || diag1 == n || diag2 == n;
            oWin = oWin || rows[i] == -n || cols[i] == -n || diag1 == -n || diag2 == -n;
        }
        if(xWin && oWin) return false; // O and X can not both win.
        if(xWin) {
            return turns == 1; // X wins, so next step should be O.
        } else if(oWin) {
            return turns == 0; // O wins, so next step should be X.
        } else {
            return turns == 1 || turns == 0; // neither of X nor O wins, so next step step should be 0(X) move or 1(O) move.
        }
    }
}
