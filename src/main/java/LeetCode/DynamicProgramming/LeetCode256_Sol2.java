package LeetCode.DynamicProgramming;

public class LeetCode256_Sol2 {
    // Solution 2: DP
    // dp[i][j]: the minimum costs of painting houses from [0, i] if paint ith house with color j
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i=1; i<costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(Math.min(dp[dp.length-1][0], dp[dp.length-1][1]), dp[dp.length-1][2]);
    }
}
