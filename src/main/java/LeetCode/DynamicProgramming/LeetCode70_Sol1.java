package LeetCode.DynamicProgramming;

/**
 * Solution 1: brute force, causing TLE.
 * Time Complexity: O(2^n)
 * Sapce Complexity: O(n)
 */
public class LeetCode70_Sol1 {
    public int climbStairs(int n) {
        int ways = 0;
        return dfs(n, ways);
    }

    private int dfs(int n, int ways) {
        if(n == 1) return ways + 1;
        if(n == 2) return ways + 2;
        return dfs(n-1, ways) + dfs(n-2, ways);
    }
}
