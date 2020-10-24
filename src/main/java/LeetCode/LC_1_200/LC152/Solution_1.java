package LeetCode.LC_1_200.LC152;

/**
 * Solution 1: brute-force.
 */
public class Solution_1 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int cur_max = 1;
            for(int j=i; j<nums.length; j++) {
                cur_max = cur_max * nums[j];
                max = Math.max(max, cur_max);
            }
        }
        return max;
    }
}
