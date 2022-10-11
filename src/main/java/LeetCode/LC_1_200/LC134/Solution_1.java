package LeetCode.LC_1_200.LC134;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int fules = 0;
            for (int j = i; j < n; j++) {
                fules += gas[j];
                fules -= cost[j];
                if (fules < 0) break;
            }
            if (fules < 0) continue;

            for (int j = 0; j < i; j++) {
                fules += gas[j];
                fules -= cost[j];
                if (fules < 0) break;
            }
            if (fules >= 0) return i;
        }
        return -1;
    }
}
