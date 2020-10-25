package LeetCode.LC_1_200.LC152;

/**
 * Solution 2: DP array, refer LC53 DP Solution_1.
 */
public class Solution_2 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        Tuple[] dp = new Tuple[nums.length];
        dp[0] = new Tuple(nums[0], nums[0]);
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            int max_so_far = Math.max(nums[i], Math.max(dp[i-1].max_so_far * nums[i], dp[i-1].min_so_far * nums[i]));
            int min_so_far = Math.min(nums[i], Math.min(dp[i-1].max_so_far * nums[i], dp[i-1].min_so_far * nums[i]));
            dp[i] = new Tuple(max_so_far, min_so_far);
            max = Math.max(max, Math.max(max_so_far, min_so_far));
        }
        return max;
    }

    class Tuple {
        public int max_so_far; // max product ending in nums[i] inclusively.
        public int min_so_far; // min product ending in nums[i] inclusively.
        public Tuple(int max, int min) {
            max_so_far = max;
            min_so_far = min;
        }
    }
}
