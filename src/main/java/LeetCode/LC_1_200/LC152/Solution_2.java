package LeetCode.LC_1_200.LC152;

/**
 * Solution 2: DP.
 * For a given nums[i], current max product can be:
 * 1> nums[i] * previous_max_product, e.g. current is 5 and previous_max_product is 10.
 * 2> nums[i] * previous_min_product, e.g. current is -5 and previous_min_product is -10.
 * 3> nums[i] itself, e.g. curr has preceding 0: [0, 5].
 */
public class Solution_2 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++) {
            int temp = max_so_far; // important, since max_so_far will be updated in next line.
            max_so_far = Math.max(Math.max(max_so_far*nums[i], min_so_far*nums[i]), nums[i]);
            min_so_far = Math.min(Math.min(min_so_far*nums[i], temp*nums[i]), nums[i]);
            result = Math.max(result, max_so_far);
        }
        return result;
    }
}
