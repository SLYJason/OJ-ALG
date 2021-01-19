package LeetCode.LC_1601_1800.LC1679;

import java.util.Arrays;

/**
 * Solution 2: two pointers.
 */
public class Solution_2 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, count = 0;
        while(i < j) {
            if(nums[i] + nums[j] < k) {
                i++;
            } else if(nums[i] + nums[j] > k) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
