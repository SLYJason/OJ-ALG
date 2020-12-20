package LeetCode.LC_201_400.LC303;

/**
 * Solution: prefix sum.
 */
public class Solution {
    class NumArray {
        int[] nums;
        public NumArray(int[] nums) {
            for(int i=1; i<nums.length; i++) {
                nums[i] = nums[i-1] + nums[i];
            }
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            return i == 0 ? nums[j] : nums[j] - nums[i-1];
        }
    }
}
