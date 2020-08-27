package LeetCode.DynamicProgramming;

/**
 * Solution 1: brute force, intuitive thoughts.
 */
public class LeetCode494_Sol1 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return count;
    }
    private void dfs(int[] nums, int S, int index, int sum) {
        if(index == nums.length) {
            if(sum == S) count++;
            return;
        }
        dfs(nums, S, index+1, sum+nums[index]);
        dfs(nums, S, index+1, sum-nums[index]);
    }
}
