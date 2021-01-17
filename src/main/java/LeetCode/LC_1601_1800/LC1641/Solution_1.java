package LeetCode.LC_1601_1800.LC1641;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public int countVowelStrings(int n) {
        return dfs(0, 5, n);
    }

    private int dfs(int pos, int choices, int n) {
        if(pos == n) return 1;
        int count = 0;
        for(int i = choices; i > 0; i--) {
            count += dfs(pos + 1, i, n);
        }
        return count;
    }
}
