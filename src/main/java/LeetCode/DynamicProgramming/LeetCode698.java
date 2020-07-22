package LeetCode.DynamicProgramming;

import java.util.stream.IntStream;

public class LeetCode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1) return true; // base case
        if(nums.length < k) return false; // base case
        int sum = IntStream.of(nums).sum();
        if(sum % k != 0) return false; // base case
        boolean[] used = new boolean[nums.length];
        return dfs(nums, k, sum/k, 0, 0, used);
    }

    private boolean dfs(int[] nums, int k, int target, int curr_sum, int index, boolean[] used) {
        if(k == 1) return true;
        if(curr_sum == target) return dfs(nums, k-1, target, 0, 0, used);
        for(int i=index; i<nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                if(dfs(nums, k, target, curr_sum+nums[i], i+1, used)) return true;
                used[i] = false;
            }
        }
        return false;
    }
}
