package LeetCode.LC_1001_1200.LC1029;

import java.util.Arrays;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        Arrays.sort(costs, (c1, c2) -> (c1[0] - c1[1] - (c2[0] - c2[1])));
        int min_costs = 0;
        for(int i=0; i<costs.length; i++) {
            min_costs += i < n ? costs[i][0] : costs[i][1];
        }
        return min_costs;
    }
}
