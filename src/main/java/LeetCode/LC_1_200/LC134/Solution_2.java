package LeetCode.LC_1_200.LC134;

/**
 * Solution 2: one pass.
 */
public class Solution_2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int cur_tank = 0, total_tank = 0, index = 0;
        for (int i = 0; i < n; i++) {
            total_tank += gas[i] - cost[i];
            cur_tank += gas[i] - cost[i];
            if (cur_tank < 0) {
                index = i + 1;
                cur_tank = 0;
            }
        }
        return total_tank >= 0 ? index : -1;
    }
}
