package LeetCode.LC_1601_1800.LC1641;

/**
 * Solution 1: brute force, concise solution.
 */
public class Solution_1 {
    int count = 0;
    public int countVowelStrings(int n) {
        dfs(0, n, 0);
        return count;
    }

    private void dfs(int start, int n, int len) {
        if(len == n) {
            count++;
            return;
        }

        for(int i=start; i<5; i++) {
            len++;
            dfs(i, n, len);
            len--;
        }
    }
}
