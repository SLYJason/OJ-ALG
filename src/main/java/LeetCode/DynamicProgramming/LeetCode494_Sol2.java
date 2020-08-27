package LeetCode.DynamicProgramming;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: Improved using memorization.
 */
public class LeetCode494_Sol2 {
    public int findTargetSumWays(int[] nums, int S) {
        // K: at current index, possible sum; V: number of ways to get sum
        Map<String, Integer> memo = new HashMap();
        return dfs(nums, S, 0, 0, memo);
    }
    private int dfs(int[] nums, int S, int index, int sum, Map<String, Integer> memo) {
        String indexSum = index + "->" + sum;
        if(memo.containsKey(indexSum)) return memo.get(indexSum);
        if(index == nums.length) {
            if(sum == S) {
                return 1;
            } else{
                return 0;
            }
        }
        int ways = dfs(nums, S, index+1, sum+nums[index], memo) + dfs(nums, S, index+1, sum-nums[index], memo);
        memo.put(indexSum, ways);
        return ways;
    }
}
