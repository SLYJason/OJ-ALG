package LeetCode.DynamicProgramming;

/**
 * Solution 2: brute force with memorization.
 * Time Complexity: O(n), only need to consider unique number in the range of [1, n].
 * Sapce Complexity: O(n).
 */
public class LeetCode70_Sol2 {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if(memo[n] != 0) return memo[n];
        memo[n] = dfs(n-1, memo) + dfs(n-2, memo);
        return memo[n];
    }
}
