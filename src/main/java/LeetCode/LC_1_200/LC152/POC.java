package LeetCode.LC_1_200.LC152;

/**
 * Proof of Concept: this only works if the array has a mix of positive numbers and negative numbers, must not include zero.
 */
public class POC {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int left = 1;
        int right = 1;
        int max = nums[0];
        for(int i=0; i<nums.length; i++) {
            left = left * nums[i];
            right = right * nums[nums.length-1-i];
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }
}
