package LeetCode.DynamicProgramming;

public class LeetCode256_Sol1 {
    // Solution 1: DFS + memorization
    int[][] memo;
    public int minCost(int[][] costs) {
        memo = new int[costs.length][3];
        return Math.min(Math.min(paint(costs, 0, 0), paint(costs, 0, 1)), paint(costs, 0, 2));
    }

    private int paint(int[][] costs, int pos, int color) {
        if(pos == costs.length) return 0;
        if(memo[pos][color] != 0) return memo[pos][color];
        int totalCosts = costs[pos][color];
        if(color == 0) {
            totalCosts += Math.min(paint(costs, pos+1, 1), paint(costs, pos+1, 2));
        } else if(color == 1) {
            totalCosts += Math.min(paint(costs, pos+1, 0), paint(costs, pos+1, 2));
        } else {
            totalCosts += Math.min(paint(costs, pos+1, 0), paint(costs, pos+1, 1));
        }
        memo[pos][color] = totalCosts;
        return totalCosts;
    }
}
