package LeetCode.DynamicProgramming;

public class LeetCode256_Sol3 {
    // Solution 3: optimal space
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int lastR = costs[0][0];
        int lastB = costs[0][1];
        int lastG = costs[0][2];
        for(int i=1; i<costs.length; i++) {
            int currR = costs[i][0] + Math.min(lastB, lastG);
            int currB = costs[i][1] + Math.min(lastR, lastG);
            int currG = costs[i][2] + Math.min(lastR, lastB);
            lastR = currR;
            lastB = currB;
            lastG = currG;
        }
        return Math.min(Math.min(lastR, lastB), lastG);
    }
}
