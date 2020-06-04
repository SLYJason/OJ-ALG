package LeetCode.Greedy;

import java.util.Arrays;

public class LeetCode1029 {
    public int twoCitySchedCost(int[][] costs) {
        int ans = 0;
        Arrays.sort(costs, (c1, c2) -> c1[0] - c1[1] - (c2[0] - c2[1]));
        for(int i=0; i<costs.length; i++) {
            ans += i < costs.length/2 ? costs[i][0] : costs[i][1];
        }
        return ans;
    }
}
